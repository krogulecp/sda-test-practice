package info.krogulec.sda.testpractice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author krogulecp
 */
class ListProcessorSamplesTest {

    @Test
    void findPrimeNumbers(){
        //given
        List<String> inputName = List.of("1", "33", "2", "3", "34", "12", "11", "18");
        //when
        List<Integer> result = new ListProcessorSamplesStreams().processNumbers(inputName);
        //then
        Assertions.assertThat(result).containsExactly(1,3,11,33);
    }

    @Test
    void shouldIgnoreNotNumbers(){
        //given
        List<String> inputName = List.of("1", "jakiś tekst", "33", "2", "3", "34", "12", "11", "18");
        //when
        List<Integer> result = new ListProcessorSamplesStreams().processNumbers(inputName);
        //then
        Assertions.assertThat(result).containsExactly(1,3,11,33);
    }

    @Test
    void shouldIgnoreEmpty(){
        //given
        List<String> inputName = List.of("1", "jakiś tekst", "33", "", "3", "34", "12", "11", "18");
        //when
        List<Integer> result = new ListProcessorSamplesStreams().processNumbers(inputName);
        //then
        Assertions.assertThat(result).containsExactly(1,3,11,33);
    }

    @Test
    void shouldIgnoreNull(){
        //given
        List<String> inputName = Arrays.asList("1", "jakiś tekst", "33", null, "3", "34", "12", "11", "18");
        //when
        List<Integer> result = new ListProcessorSamplesStreams().processNumbers(inputName);
        //then
        Assertions.assertThat(result).containsExactly(1,3,11,33);
    }

    //assertj collections assertions examples
    @Test
    void shouldReturnCorrectElements(){
        //given
        List<String> inputName = Arrays.asList("1", "jakiś tekst", "33", null, "3", "34", "12", "11", "18");
        //when
        List<Integer> result = new ListProcessorSamplesStreams().processNumbers(inputName);
        //then
        Assertions.assertThat(result)
                .isNotEmpty()
                .hasSize(4)
                .containsAnyOf(1,3,11,33,12,32,122,44)
                .containsOnlyOnce(1)
                .doesNotContain(34,12,18); //i wiele więcej...

    }

    @Test
    void shouldThrowExceptionWithNullInput(){
        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> new ListProcessorSamplesStreams().processNumbers(null));
        Assertions.assertThat(invalidInputException.getMessage()).isEqualTo("Input cannot be null");
    }
}