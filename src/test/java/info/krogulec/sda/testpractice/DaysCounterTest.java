package info.krogulec.sda.testpractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author krogulecp
 */
class DaysCounterTest {

    private DaysCounter daysCounter;

    @BeforeEach
    void setUp() {
        daysCounter = new DaysCounter();
    }

    //czy jest jakiś problem z tym testem?
    @Test
    void should_count_days_by_today(){
        int days = daysCounter.countDays(LocalDate.parse("2019-02-23"));
        assertEquals(-365, days);
    }

    @ParameterizedTest
    @CsvSource(value = {
          ""
    })
    void should_count_days_by_today_par(){
        int days = daysCounter.countDays(LocalDate.parse("2019-02-23"));
        assertEquals(-365, days);
    }
}