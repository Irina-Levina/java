import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private static HashMap<String, String> phoneBook;

    //создаем книгу
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    //проверяем правильность формата телефона
    public boolean isValidPhoneFormat(String phone) {
        Pattern phoneFormat = Pattern.compile("([78])\\d{10}");
        Matcher matchPhone = phoneFormat.matcher(phone);
        return matchPhone.matches();
    }

    //проверяем правильность формата имени? без фамилии
    public boolean isValidNameFormat(String name) {
        Pattern nameFormat = Pattern.compile("[a-zA-Z]+|[а-яА-Я]+");
        Matcher matchName = nameFormat.matcher(name);
        return matchName.matches();
    }

    public boolean isExistName(String name){
        return phoneBook.containsValue(name);
    }
    public boolean isExistPhoneNumber(String phone){
        return phoneBook.containsKey(phone);
    }


    public void addContact(String phone, String name) {
        if (isValidPhoneFormat(phone) & isValidNameFormat(name)) {
            phoneBook.put(phone, name);
        }
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getNameByPhone(String phone) {
        if (isValidPhoneFormat(phone) & phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        } else
            return "";
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

    }

    public Set<String> getPhonesByName(String name) {
        TreeSet<String> phones = new TreeSet<>();
        for (Map.Entry entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                phones.add(name + " - " + entry.getKey().toString());
            }
        }
        return phones;
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

    }

    public Set<String> getAllContacts() {
        TreeSet<String> allContacts = new TreeSet<>();
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        for (String key : phoneBook.keySet()) {
            allContacts.add(phoneBook.get(key) + " - " + key);
        }
        return allContacts;
    }

}