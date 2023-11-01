package lesson_35._01_old;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        System.out.println(now.getTime());
        Date sqlDate = new Date(12345467890154l);
        System.out.println(sqlDate);
        System.out.println(now.after(sqlDate));
        System.out.println(now.compareTo(sqlDate));

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(6));
        cal.set(Calendar.YEAR, 2024);
        System.out.println(cal.getTime());
        cal.add(Calendar.MONTH, 1);
        System.out.println(cal.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat();
        String formattedDate = formatter.format(new Date());
        System.out.println(formattedDate);

        String pattern = "dd 'aaa' MMMM 'bbb' y  HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        System.out.println(format.format(new Date()));

        String someDate = "15-06-1990";
        String pat = "dd-MM-y";
        SimpleDateFormat sdf = new SimpleDateFormat(pat);
        Date date = sdf.parse(someDate);
        System.out.println(date);
    }
}
