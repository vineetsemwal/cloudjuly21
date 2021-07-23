package corejava.datedemos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    private final String pattern = "dd-MM-yy";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);


    public String toText(LocalDate date) {
        String text=formatter.format(date);
        return text;
    }

    public LocalDate toDate(String text) {
        LocalDate date = LocalDate.parse(text, formatter);
        return date;
    }

}
