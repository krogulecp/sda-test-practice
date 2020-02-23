package info.krogulec.sda.testpractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author krogulecp
 */
class DaysCounterSamples {

    SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

    public long daysFromDate(String inputString1){
        long days = 0;
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("Podaj datę w formacie: dd MM yyyy");
        LocalDate todaysDate = LocalDate.now();
        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = Date.from(todaysDate.atStartOfDay(defaultZoneId).toInstant());;
            long diff = date2.getTime() - date1.getTime();
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            System.out.println("liczba to" + days);
            days= (diff / (1000*60*60*24));
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    int countDaysTomek(LocalDate data) {
        int iloscDni = 0;
        Period periodBetween = Period.between(data, LocalDate.now());
        iloscDni = periodBetween.getDays();
        iloscDni += periodBetween.getYears() * 360;
        iloscDni += periodBetween.getMonths() * 30;
        return iloscDni;
    }

    long countDaysPiotr(LocalDate nextDate){
        LocalDate today = LocalDate.now();
        Duration duration = Duration.between(today.atStartOfDay(), nextDate.atStartOfDay());
        return duration.toDays();
    }
}
