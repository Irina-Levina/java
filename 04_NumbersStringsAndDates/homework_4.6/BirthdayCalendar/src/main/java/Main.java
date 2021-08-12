

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        Calendar birthday = new GregorianCalendar(year,(month - 1),day);
        Calendar today = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);
        StringBuilder allBirthday = new StringBuilder();
        int i = 0;

        while (birthday.before(today))
        {
            allBirthday.append(i).append(" - ").append(dateFormat.format(birthday.getTime())).append(System.lineSeparator());
            birthday.roll(Calendar.YEAR, 1);
            i++;
        }
        return allBirthday.toString();

    }
}
