package corejava.datedemos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {
    private final String pattern = "dd-MM-yy_HH:mm";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);


    public String toText(LocalDateTime dateTime) {
        String text=formatter.format(dateTime);
        return text;
    }

    public LocalDateTime toDateTime(String text) {
        LocalDateTime date = LocalDateTime.parse(text, formatter);
        return date;
    }


}
