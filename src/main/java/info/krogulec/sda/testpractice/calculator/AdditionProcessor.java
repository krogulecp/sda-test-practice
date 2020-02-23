package info.krogulec.sda.testpractice.calculator;

/**
 * @author krogulecp
 */
class AdditionProcessor implements OperationProcessor {

    @Override
    public double process(int arg1, int arg2) {
        return arg1 + arg2;
    }

    @Override
    public Operation getOperation() {
        return Operation.ADD;
    }
}
