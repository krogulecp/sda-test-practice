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
    @CsvSource(value = {
            "czesław,To nie jest imię żeńskie!",
            "anna maria,Więcej niż jedno słowo!",
            ",Imię nie może być nullem",
            "       a,To nie jest imię żeńskie!",
            "Anna;.,To nie jest imię żeńskie!",
            "la,To nie jest imię żeńskie!"
    })
    void should_throw_exception_with_invalid_input(String inputName, String expectedMessage){

        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> femaleNameChecker.nameGenerate(inputName));
        assertEquals(expectedMessage, exception.getMessage());
    }
}