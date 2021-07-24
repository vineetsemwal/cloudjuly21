package corejava.datedemos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DifferenceDays {

    public long days(LocalDateTime startDateTime, LocalDateTime endDateTime){
        LocalDate startDate = startDateTime.toLocalDate();
        LocalDate endDate = endDateTime.toLocalDate();
        long days=ChronoUnit.DAYS.between(startDate,endDate);
       return days;
    }

    public long days(LocalDate startDate, LocalDate endDate){
           long days=ChronoUnit.DAYS.between(startDate,endDate);
        return days;
    }

}
