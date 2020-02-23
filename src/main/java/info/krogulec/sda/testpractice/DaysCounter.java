package info.krogulec.sda.testpractice;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author krogulecp
 */
class DaysCounter {

    int countDays(LocalDate date){
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(date, today);
        return (int) daysBetween;
    }
}
