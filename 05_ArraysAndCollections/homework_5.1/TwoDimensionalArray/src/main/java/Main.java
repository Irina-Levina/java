import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] array = TwoDimensionalArray.getTwoDimensionalArray(20);
        System.out.println(array.length);
        Arrays.stream(array).forEach(System.out::println);
    }
}
