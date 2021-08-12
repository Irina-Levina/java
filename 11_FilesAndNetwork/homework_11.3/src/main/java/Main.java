import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    private static class Summary {
         double income;
         double outgo;

        Summary(double income, double outgo) {
            this.income = income;
            this.outgo = outgo;
        }

        /* сложение сумм */
        static Summary merge(Summary s1, Summary s2) {
            return new Summary(s1.income + s2.income, s1.outgo + s2.outgo);
        }
        /* mapper - конвертация из Transaction */
        static Summary fromTransaction(Movement t) {
            return new Summary(t.getIncome(), t.getOutgo());
        }

        @Override
        public String toString() {
            return "income=" + income +
                    ", outgo=" + outgo +
                    '}';
        }
    }


    public static void main(String[] args) {

        Movements movements = new Movements("B:\\Java\\java_basics\\11_FilesAndNetwork\\files\\movementList.csv");

        System.out.println("Сумма расходов: " + movements.getExpenseSum());
        System.out.println("Сумма доходов: " + movements.getIncomeSum());

        List<Movement> movementList;
        movementList = movements.getMovementList();

        movementList.forEach(movement -> System.out.println(movement.getCompanyName() + " outgo:\t " + movement.getOutgo()));

        System.out.println("\n\n\n");


        movementList.stream()
                .collect(groupingBy(Movement::getCompanyName, Collectors.mapping((m) -> new Summary(m.getIncome(),m.getOutgo()),
                        reducing(Summary::merge)))).
                forEach((s, summ) -> System.out.println(s + "\n\t\t\tДоход: " + summ.get().income + "\n\t\t\tРасход: " + summ.get().outgo  ));

    }
}
