package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormater {

    private static final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String dateFormat(String date){
        return LocalDate.parse(date, inputFormat).format(outputFormat);
    }
}
