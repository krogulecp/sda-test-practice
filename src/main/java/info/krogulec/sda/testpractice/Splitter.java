package info.krogulec.sda.testpractice;


/**
 * @author krogulecp
 */
class Splitter {

    //Metoda, która przyjmie Stringa, który będzie składał się z numerów i na wyjściu dostaniemy sumę tych numerów
    //Na wejściu mamy np. "123" i na wyjściu mamy 6
    public int splitNumbers(String numbers){
        int suma =0;
        String[] numbersArr = numbers.split("");
        for (int i = 0; i < numbersArr.length; i++){
            try {
                suma += Integer.parseInt(numbersArr[i]);
            } catch (NumberFormatException e){
                throw new InvalidInputException("Błąd parsowania liczby: " + numbersArr[i], e);
            }
        }
        return suma;
    }




    public int splitNumbersForeach(String numbers){
        int suma =0;
        String[] numbersArr = numbers.split("");
        for (String s : numbersArr) {
            int result = Integer.parseInt(s);
            suma += result;
        }
        return suma;
    }
}
