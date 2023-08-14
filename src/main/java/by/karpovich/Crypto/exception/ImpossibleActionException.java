package by.karpovich.Crypto.exception;

public class ImpossibleActionException extends RuntimeException {
    public ImpossibleActionException() {
    }

    public ImpossibleActionException(String message) {
        super(message);
    }
}
