package vs.korzhina.SecondSpringBootApp.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import vs.korzhina.SecondSpringBootApp.exception.*;
import vs.korzhina.SecondSpringBootApp.model.Request;

@Service
public interface IValidationService {

    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isUnsupportedCodeException(@RequestBody Request request) throws UnsupportedCodeException;
}