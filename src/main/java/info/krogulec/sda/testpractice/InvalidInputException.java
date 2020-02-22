package info.krogulec.sda.testpractice;

/**
 * @author krogulecp
 */
class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
