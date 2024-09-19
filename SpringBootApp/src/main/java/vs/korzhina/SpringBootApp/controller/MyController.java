package vs.korzhina.SpringBootApp.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vs.korzhina.SpringBootApp.exception.UnsupportedCodeException;
import vs.korzhina.SpringBootApp.exception.ValidationFailedException;
import vs.korzhina.SpringBootApp.model.Request;
import vs.korzhina.SpringBootApp.model.Response;
import vs.korzhina.SpringBootApp.service.IValidationService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyController {
    private final IValidationService validationService;

    @Autowired
    public MyController(IValidationService validationService) {
        this.validationService = validationService;
    }

@PostMapping(value="/feedback")
public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                            BindingResult bindingResult) {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(simpleDateFormat.format(new Date()))
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

    try {
        validationService.isValid(bindingResult);
        validationService.isUnsupportedCodeException(request);
    } catch (UnsupportedCodeException e) {
        response.setCode("failed");
        response.setErrorCode("UnsupportedCodeException");
        response.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch (ValidationFailedException e) {
        response.setCode("failed");
        response.setErrorCode("ValidationException");
        response.setErrorMessage("Ошибка валидации");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch(Exception e){
        response.setCode("failed");
        response.setErrorCode("UnknownException");
        response.setErrorMessage("Произошла непредвиденная ошбика");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
}

}
