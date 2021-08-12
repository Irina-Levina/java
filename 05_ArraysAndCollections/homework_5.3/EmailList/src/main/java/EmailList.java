import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailList {
    private TreeSet<String> emailList;

    public EmailList() {
        emailList = new TreeSet<>();
    }

    public void add(String email) {
        if (isValidFormat(email)) {
            emailList.add(email.toLowerCase(Locale.ROOT));
        }
    }

    public TreeSet<String> getEmailList() {
        return emailList;
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList<>(getEmailList());
    }

    public static boolean isValidFormat(String str) {

        Pattern pattern = Pattern.compile("[\\w.]*[@][a-zA-Z]*[.](ru|com)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

}
