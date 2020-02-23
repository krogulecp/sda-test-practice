package info.krogulec.sda.testpractice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author krogulecp
 */
class DaysCounterSamplesTest {

    private DaysCounterSamples daysCounterSamples;

    @BeforeEach
    void setUp() {
        daysCounterSamples = new DaysCounterSamples();
    }

    @Test
    void should_return_0_with_same_date(){
        //when
        long days = daysCounterSamples.countDaysPiotr(LocalDate.now());

        assertEquals(0, days);
    }

    @Test
    void should_return_1_with_one_day_before(){
        //when
        long days = daysCounterSamples.countDaysTomek(LocalDate.now().minusDays(1));

        assertEquals(1, days);
    }

    @Test
    void should_return_minus_1_with_one_day_after(){
        //when
        long days = daysCounterSamples.countDaysTomek(LocalDate.now().plusDays(1));

        assertEquals(-1, days);
        Assertions.assertThat(days)
                .isNegative()
                .isBetween(-2L,0L)
                .isNotEqualTo(3)
                .isNotZero();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0,0,-360",
            "-1,0,0,360",
            "1,1,0,-390",
            "1,1,1,-391",
            "2,-1,0,-690"
    })
    void should_return_valid_period(int yearsFromToday, int monthsFromToday, int daysFromToday, int expectedResult){
        //given
        LocalDate testedDate = LocalDate.now()
                .plusYears(yearsFromToday)
                .plusMonths(monthsFromToday)
                .plusDays(daysFromToday);

        //when
        int actualResult = daysCounterSamples.countDaysTomek(testedDate);

        //then
        Assertions.assertThat(actualResult).isEqualTo(expectedResult)
                .isNotNull();
    }
}