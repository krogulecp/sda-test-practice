package info.krogulec.sda.testpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author krogulecp
 */
class ListProcessorSamples {

    List<Integer> processNumbers (List<String> numberStrings){
        List<Integer> processNumbersTemplate = new ArrayList<>();
        for (String s:numberStrings) {
            if (isNumeric(s))
                processNumbersTemplate.add(Integer.parseInt(s));
        }
        return processNumbersTemplate;
    }

    private List<Integer> getNotEvenNumbers (List<Integer> numbers){
        List<Integer> givenNumbers = new ArrayList<>();
        for (int x : numbers) {
            if (isOdd(x)){
                givenNumbers.add(x);
            }
        }
        return givenNumbers;
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
