package corejava.datedemos;

import java.time.LocalDate;

public class DateConverterMain {
    public static void main(String[] args){
        LocalDate date= LocalDate.of(2021,06,20);
        DateConverter converter=new DateConverter();
        String text=converter.toText(date);
        System.out.println("converted from date to text="+text);

        LocalDate convertedDate=converter.toDate(text);
        System.out.println("converted date="+convertedDate.getDayOfMonth() +" "+convertedDate.getYear());

    }
}
