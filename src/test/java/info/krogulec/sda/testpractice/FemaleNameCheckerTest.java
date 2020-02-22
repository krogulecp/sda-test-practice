package info.krogulec.sda.testpractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author krogulecp
 */
class FemaleNameCheckerTest {

    private FemaleNameChecker femaleNameChecker;

    @BeforeEach
    void setUp() {
        femaleNameChecker = new FemaleNameChecker();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "AniA,Ania",
            "ania,Ania",
            "   ania   ,Ania",
            "ALA,Ala"
    })
    void should_return_valid_female_name(String inputName, String expectedResult){
        //when
        String name = femaleNameChecker.nameGenerate(inputName);

        //then
        assertEquals(expectedResult, name);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "czesław", "anna maria", "", "              a", "Anna;.", "la"
    })
    void should_throw_exception_with_invalid_input(String inputName){

        assertThrows(InvalidInputException.class, () -> femaleNameChecker.nameGenerate(inputName));
    }
}