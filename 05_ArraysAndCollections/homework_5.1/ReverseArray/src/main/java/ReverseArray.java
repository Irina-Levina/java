public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse(String[] strings) {
        int average = strings.length / 2;

        for (int i = 0; i <= average; i++) {
            String buffer = strings[i];
            strings[i] = strings[strings.length - i - 1];
            strings[strings.length - i - 1] = buffer;
        }
        return strings;
    }
}
