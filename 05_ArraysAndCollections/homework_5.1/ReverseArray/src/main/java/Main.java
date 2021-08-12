
public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] backwards = ReverseArray.reverse(line.split("\\s"));
        for (String backward : backwards) {
            System.out.println(backward);
        }


    }
}
