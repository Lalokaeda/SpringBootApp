package vs.korzhina.SpringBootApp.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import vs.korzhina.SpringBootApp.exception.UnsupportedCodeException;
import vs.korzhina.SpringBootApp.exception.ValidationFailedException;
import vs.korzhina.SpringBootApp.model.Request;

@Service
public class RequestValidationService implements IValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors())
        throw new 
        ValidationFailedException(bindingResult.getFieldError().toString());
    }

    @Override
    public void isUnsupportedCodeException(Request request) throws UnsupportedCodeException {
        if (request.getUid().equals("123"))
        throw new UnsupportedCodeException("Не поддерживаемая ошибка");
    }

}
