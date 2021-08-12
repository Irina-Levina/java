import net.sf.saxon.expr.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException();
        }
        if (!correctEmail(components[INDEX_EMAIL])) {
            throw new WrongEmailFormat("Wrong email format!\nPlease, enter correct email!");
        }
        if (!correctPhoneFormat(components[INDEX_PHONE])) {
            throw new WrongPhoneFormat("Wrong phone number format!\n Please, enter correct phone number!");
        }
        if (!correctNameFormat(components[INDEX_NAME], components[INDEX_SURNAME])) {
            throw new WrongNameFormat("Wrong name format!\n Please, enter correct name!");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {

        storage.remove(name);


    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    private boolean correctEmail(String email) {
        Pattern pattern = Pattern.compile("\\w{1,}[@][a-zA-Z]{1,}[.]{1}[a-zA-Z]{1,}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean correctPhoneFormat(String phone) {
        Pattern pattern = Pattern.compile("[+]{1}[8|7]\\d{10}");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean correctNameFormat(String name, String surname) {
        Pattern pattern = Pattern.compile("[А-Я]{1}[а-я]{1,}");
        Matcher matcher = pattern.matcher(name);
        Matcher matcher1 = pattern.matcher(surname);
        return matcher.matches() & matcher1.matches();
    }
}