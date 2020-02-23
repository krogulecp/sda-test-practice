package info.krogulec.sda.testpractice.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author krogulecp
 */
class CalculatorTest {

    private OperationProcessor operationProcessorMock;

    @BeforeEach
    void setUp() {
        operationProcessorMock = Mockito.mock(OperationProcessor.class);
    }

    @Test
    void should_add_two_numbers(){
        //given
        Calculator calculator = new Calculator(3, 10, Set.of(new AdditionProcessor()), Operation.ADD);

        //when
        double result = calculator.calculate();

        //then
        assertEquals(13, result);
    }

    @Test
    void should_process_two_numbers(){
        //given
        Mockito.when(operationProcessorMock.getOperation()).thenReturn(Operation.DIVIDE);
        Mockito.when(operationProcessorMock.process(4,5)).thenReturn(123.0);
        Calculator calculator = new Calculator(4, 5, Set.of(operationProcessorMock), Operation.DIVIDE);

        //when
        double result = calculator.calculate();

        //then
        assertEquals(123.0, result);
    }

}