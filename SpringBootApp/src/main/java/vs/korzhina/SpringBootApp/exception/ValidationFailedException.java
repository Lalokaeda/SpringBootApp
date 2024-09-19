package vs.korzhina.SpringBootApp.exception;

public class ValidationFailedException extends Exception {

    public ValidationFailedException(String message){
        super(message);
    }
}
