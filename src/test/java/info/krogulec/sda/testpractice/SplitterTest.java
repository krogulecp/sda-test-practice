package info.krogulec.sda.testpractice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author krogulecp
 */
class SplitterTest {

    @Test
    @DisplayName("should return 6 with 123 input")
    void should_return_6_with_123_input(){
        //given
        Splitter splitter = new Splitter();

        //when
        int result = splitter.splitNumbers("123");

        //then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("should return 6 with 123 input")
    void should_return_6_with_123_input_when_calling_foreach(){
        //given
        Splitter splitter = new Splitter();

        //when
        int result = splitter.splitNumbersForeach("123");

        //then
        assertEquals(6, result);
    }

//    @Test
//    void should_throw_exception_whit_invalid_numbers_input(){
//        //given
//        Splitter splitter = new Splitter();
//
//        //when and then
//        assertThrows(InvalidInputException.class, () -> splitter.splitNumbers("x22"));
//    }


}