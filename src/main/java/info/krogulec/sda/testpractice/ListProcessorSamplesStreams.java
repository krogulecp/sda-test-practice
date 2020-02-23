package info.krogulec.sda.testpractice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author krogulecp
 */
class ListProcessorSamplesStreams {

    List<Integer> processNumbers (List<String> numberStrings){
        validateInput(numberStrings);
        List<Integer> numbers = numberStrings.stream()
                .filter(this::isNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> notEvenNumbers = getNotEvenNumbers(numbers);
        return orderNumbers(notEvenNumbers);
    }

    private void validateInput(List<String> object) {
        if (object == null){
            throw new InvalidInputException("Input cannot be null");
        }
    }

    private List<Integer> getNotEvenNumbers (List<Integer> numbers){
        return numbers.stream()
                .filter(this::isOdd)
                .collect(Collectors.toList());
    }

    private List<Integer> orderNumbers (List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
