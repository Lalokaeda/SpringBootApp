package vs.korzhina.SecondSpringBootApp.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import vs.korzhina.SecondSpringBootApp.exception.UnsupportedCodeException;
import vs.korzhina.SecondSpringBootApp.exception.ValidationFailedException;
import vs.korzhina.SecondSpringBootApp.model.Request;
import vs.korzhina.SecondSpringBootApp.model.Response;

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
