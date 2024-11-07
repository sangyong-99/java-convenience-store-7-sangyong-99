package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class LocalDateUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static LocalDate parse(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(date, dateFormatter);
    }
}