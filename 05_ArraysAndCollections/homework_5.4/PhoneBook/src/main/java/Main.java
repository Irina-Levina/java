import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String flag;
        String phoneNumber;
        String name;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя, номер или команду");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            if (input.contains("LIST")) {
                flag = "LIST";
            } else {
                if (phoneBook.isValidNameFormat(input) & !input.contains("LIST")) {
                    flag = "NAME";
                } else if (phoneBook.isValidPhoneFormat(input)) {
                    flag = "PHONE";
                } else {
                    flag = "ERROR";
                }
            }

            switch (flag) {
                case "LIST":
                    for (String item : phoneBook.getAllContacts()) {
                        System.out.println(item);
                    }
                    break;

                case "PHONE":
                    if (phoneBook.isExistPhoneNumber(input)) {
                        System.out.println(phoneBook.getNameByPhone(input));
                    } else {
                        System.out.println("Такого номера нет в телефонной книге");
                        System.out.println("Ввеедите имя для абонета \"" + input + "\" ");
                        Scanner scanner1 = new Scanner(System.in);
                        name = scanner1.nextLine();
                        phoneBook.addContact(input, name);
                        System.out.println("Контакт добавлен!");
                    }
                    break;

                case "NAME":
                    if (phoneBook.isExistName(input)) {
                        for (String item : phoneBook.getPhonesByName(input)) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Такого имени в телефонной книге нет");
                        System.out.println("Введите номер телефона для абонента  \"" + input + "\"");
                        Scanner phoneScan = new Scanner(System.in);
                        phoneNumber = phoneScan.nextLine();
                        phoneBook.addContact(phoneNumber, input);
                        System.out.println("Контакт добавлен!");
                    }
                    break;

                case "ERROR":
                    System.out.println("Неверный формат ввода!");
                    break;
            }

        }


    }

}

