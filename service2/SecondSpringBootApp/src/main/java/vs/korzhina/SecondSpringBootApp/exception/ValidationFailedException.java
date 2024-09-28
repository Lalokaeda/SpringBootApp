package vs.korzhina.SecondSpringBootApp.exception;

public class ValidationFailedException extends Exception {

    public ValidationFailedException(String message){
        super(message);
    }
}
