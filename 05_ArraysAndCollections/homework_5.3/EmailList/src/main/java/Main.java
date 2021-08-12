import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static final EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            if (input.contains("ADD")) {
                StringBuilder stringBuilder = new StringBuilder(input);
                input = stringBuilder.substring(3).trim();
                if (EmailList.isValidFormat(input)) {
                    emailList.add(input);
                } else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            } else if (input.contains("LIST")) {
                TreeSet<String> list = emailList.getEmailList();
                for (String item : list) {
                    System.out.println(item);
                }
            }
            //TODO: write code here

        }
    }
}
