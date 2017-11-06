package main.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String DATE_FORMAT = "dd.MM.yyyy";


    public static String format (Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    public static Date parse (String source) throws ParseException {
        if (source == null || source.equals("")) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMAT).parse(source);
    }

}
