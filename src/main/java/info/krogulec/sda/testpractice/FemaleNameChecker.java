package info.krogulec.sda.testpractice;


/**
 * @author krogulecp
 */
class FemaleNameChecker {

    public String nameGenerate (String name){
        String[] letterArray = name.trim().toLowerCase().split("");
        for (String s : letterArray){
            if (s.equals(" ")){
                throw new InvalidInputException("Więcej niż jedno słowo!");
            }
        }
        if (letterArray[letterArray.length - 1].equals("a") && letterArray.length > 2){
            letterArray[0] = letterArray[0].toUpperCase();
            String result = "";
            for (String s : letterArray){
                result = result + s;
            } return result;
        } else throw new InvalidInputException("To nie jest imię żeńskie!");
    }
}
