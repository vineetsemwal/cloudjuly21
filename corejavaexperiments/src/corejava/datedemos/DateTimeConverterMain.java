package corejava.datedemos;

import java.time.LocalDateTime;

public class DateTimeConverterMain {

    public static void main (String args[]){
        DateTimeConverter converter = new DateTimeConverter();
        LocalDateTime dateTime=LocalDateTime.now();
        String text=converter.toText(dateTime);
        System.out.println("date time text="+text);
        LocalDateTime converted=converter.toDateTime(text);
        System.out.println("date time= "+converted.getDayOfMonth()+" "+converted.getHour()+" "+converted.getMinute());

    }
}
