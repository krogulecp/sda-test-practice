package info.krogulec.sda.testpractice.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Set;

/**
 * @author krogulecp
 */
class Program {

    private final Set<OperationProcessor> operationProcessors;
    private final UserInterface userInterface;

    public Program(Set<OperationProcessor> processors) {
        this.operationProcessors = processors;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
        this.userInterface = new UserInterface(bufferedReader, printStream);
    }

    void run() throws IOException {
        Operation operation = userInterface.provideOperation();
    }
}
