

import java.util.*;

public class CoolNumbers {
    public static final String LETTERS = "АВЕКМНОРСТУХ";


    public static List<String> generateCoolNumbers() {


        //XYZ — различный набор из списка разрешенных букв, N — цифры, R — регион (от 01 до 199);
        //X NNN YZR — пример: A111BC197, У777HC66.
        ArrayList<String> coolNumbers = new ArrayList<>();
        for (int x = 0; x < LETTERS.length(); x++) {
            for (int n1 = 0; n1 < 10; n1++) {
                for (int y = 0; y < LETTERS.length(); y++) {
                    for (int z = 0; z < LETTERS.length(); z++) {
                        for (int r = 1; r < 200; r++) {
                            StringBuilder cool = new StringBuilder();
                            cool.append(LETTERS.charAt(x));
                            cool.append(n1).append(n1).append(n1);
                            cool.append(LETTERS.charAt(y));
                            cool.append(LETTERS.charAt(z));
                            if (r < 10) {
                                cool.append("0").append(r);
                            } else {
                                cool.append(r);
                            }
                            coolNumbers.add(cool.toString());
                        }
                    }
                }
            }
        }

        return coolNumbers;
    }

    public static boolean isFormats(String number) {
        String pattern = String.format("^[%s]\\d{3}[%s]{2}\\d{2,3}$", LETTERS, LETTERS);
        return number.matches(pattern);
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        ArrayList<String> coolNumbers = new ArrayList<>(list);
        boolean isFind = false;
        for (String coolNumber : coolNumbers) {
            if (coolNumber.equals(number)) {
                isFind = true;
                break;
            }
        }
        return isFind;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        int i = Collections.binarySearch(sortedList, number);
        boolean isFind = false;

        if (i >= 0) {
            isFind = true;
        }
        return isFind;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
