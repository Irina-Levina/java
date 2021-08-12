import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {

        ArrayList<String> coolNumbers = new ArrayList<>(CoolNumbers.generateCoolNumbers());

        System.out.println("Введите номер для поиска");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (CoolNumbers.isFormats(input)) {
            long t1 = System.nanoTime();
            CoolNumbers.bruteForceSearchInList(coolNumbers, input);
            long t11 = System.nanoTime();
            Collections.sort(coolNumbers);
            long t2 = System.nanoTime();
            boolean binarySearch = CoolNumbers.binarySearchInList(coolNumbers, input);
            long t22 = System.nanoTime();
            HashSet<String> coolSet = new HashSet<>(coolNumbers);
            long t3 = System.nanoTime();
            CoolNumbers.searchInHashSet(coolSet, input);
            long t33 = System.nanoTime();
            TreeSet<String> coolTree = new TreeSet<>(coolNumbers);
            long t4 = System.nanoTime();
            CoolNumbers.searchInTreeSet(coolTree, input);
            long t44 = System.nanoTime();

            if (binarySearch == true) {
                System.out.println("Номер найден за: Поиск перебором  = " + (t11 - t1) / 1000 + "мкс");
                System.out.println("Номер найден за: Бинарный поиск  = " + (t22 - t2) / 1000 + "мкс");
                System.out.println("Номер найден за: Поиск по HeshSet  = " + (t33 - t3) / 1000 + "мкс");
                System.out.println("Номер найден за: Поиск по Treemap  = " + (t44 - t4) /1000 + "мкс");
            } else {
                System.out.println("Номер не найден за: Поиск перебором  = " + (t11 - t1)/ 1000 + "мкс");
                System.out.println("Номер не найден за: Бинарный поиск = " + (t22 - t2)/ 1000 + "мкс");
                System.out.println("Номер не найден за: Поиск по HeshSet  = " + (t33 - t3)/ 1000 + "мкс");
                System.out.println("Номер не найден за: Поиск по Treemap  = " + (t44 - t4)/ 1000 + "мкс");
            }
        } else {
            System.out.println("Неверный формат");
        }

    }
}
