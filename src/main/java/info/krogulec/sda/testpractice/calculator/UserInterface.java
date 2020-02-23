package info.krogulec.sda.testpractice.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * @author krogulecp
 */
class UserInterface {

    private final BufferedReader in;
    private final PrintStream out;

    public UserInterface(BufferedReader in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    Operation provideOperation() throws IOException {
        out.println("Fill operation. Possible values are: " + Arrays.toString(Operation.values()));
        return Operation.valueOf(in.readLine());
    }

    int provideArg() throws IOException {
        out.println("Fill number");
        return Integer.parseInt(in.readLine());
    }

    void printResult(double result){
        out.println("Result is: " + result);
    }

    boolean shouldContinue() throws IOException {
        out.println("Czy kontynuować? Możliwe wartości y/n");
        String input = in.readLine();
        boolean ctn = true;
        boolean output = false;

        while (ctn){
            if ("y".equals(input)){
                output = true;
                ctn = false;
            } else if("n".equals(input)){
                output = false;
                ctn = false;
            } else {
                out.println("Podaj wartość y lub n");
                ctn = true;
            }
        }
        return output;
    }


}
