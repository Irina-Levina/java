
import java.util.List;
public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);


        for (Employee employee : staff) {
            System.out.println(employee);
        }

        sortBySalaryAndAlphabet(staff);


        System.out.println("_______________\n");
        for (Employee employee : staff) {
            System.out.println(employee);
        }

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
        staff.sort((emp1, emp2) -> {
            if (emp1.getSalary().compareTo(emp2.getSalary()) == 0) {
                return emp1.getName().compareTo(emp2.getName());
            } else return emp1.getSalary().compareTo(emp2.getSalary());

        });
    }
}