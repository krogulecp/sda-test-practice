package info.krogulec.sda.testpractice.calculator;

import java.io.IOException;
import java.util.Set;

/**
 * @author krogulecp
 */
class Main {
    public static void main(String[] args) throws IOException {
        new Program(Set.of(new AdditionProcessor())).run();
    }
}
