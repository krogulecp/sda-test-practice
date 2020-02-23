package info.krogulec.sda.testpractice.calculator;

import java.util.Set;

/**
 * @author krogulecp
 */
class Calculator {

    private final int arg1;
    private final int arg2;
    private final Set<OperationProcessor> operationProcessors;
    private final Operation operation;

    public Calculator(int arg1, int arg2, Set<OperationProcessor> operationProcessors, Operation operation) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.operationProcessors = operationProcessors;
        this.operation = operation;
    }

    double calculate(){
        OperationProcessor operationProcessor = provideProcessor();
        return operationProcessor.process(arg1,arg2);
    }

    private OperationProcessor provideProcessor(){
        return operationProcessors.stream()
                .filter(operationProcessor -> operationProcessor.getOperation().equals(operation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Brak processora dla danej operacji"));
    }
}
