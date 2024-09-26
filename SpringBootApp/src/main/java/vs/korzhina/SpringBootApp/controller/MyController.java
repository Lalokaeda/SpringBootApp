package vs.korzhina.SpringBootApp.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import vs.korzhina.SpringBootApp.exception.UnsupportedCodeException;
import vs.korzhina.SpringBootApp.exception.ValidationFailedException;
import vs.korzhina.SpringBootApp.model.Codes;
import vs.korzhina.SpringBootApp.model.ErrorCodes;
import vs.korzhina.SpringBootApp.model.ErrorMessages;
import vs.korzhina.SpringBootApp.model.Request;
import vs.korzhina.SpringBootApp.model.Response;
import vs.korzhina.SpringBootApp.service.IModifyResponseService;
import vs.korzhina.SpringBootApp.service.IValidationService;
import vs.korzhina.SpringBootApp.util.DateTimeUtil;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
public class MyController {
    private final IValidationService validationService;
    private final IModifyResponseService modifyResponseService;

    @Autowired
    public MyController(IValidationService validationService, 
                        @Qualifier("ModifySystemTimeResponseService") IModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService=modifyResponseService;
    }

@PostMapping(value="/feedback")
public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                            BindingResult bindingResult) {

    log.info("request: {}", request);                                            
    Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    log.info("response: {}", response);  

    if (bindingResult.hasErrors()) {
        StringBuilder errorMessages = new StringBuilder("Validation errors: ");
        bindingResult.getFieldErrors().forEach(error -> {
            errorMessages.append(String.format("[%s: %s] ", error.getField(), error.getDefaultMessage()));
        });
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
        response.setErrorMessage(ErrorMessages.VALIDATION);
        
        log.error("Validation failed: {}", errorMessages.toString());
        log.error("response after validation errors: {}", response);
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    try {
        validationService.isValid(bindingResult);
        validationService.isUnsupportedCodeException(request);
    } catch (UnsupportedCodeException e) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNSUPPORTED);
        log.error("response unsupported exception: {}", response, e.getMessage());  
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch (ValidationFailedException e) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
        response.setErrorMessage(ErrorMessages.VALIDATION);
        log.error("response validation exception: {}", response, e.getMessage()); 
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch(Exception e){
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNKNOWN);
        log.error("response unknown exception: {}", response, e.getMessage()); 
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    modifyResponseService.modify(response);
    log.info("response after modification: {}", response);

    return new ResponseEntity<>(response, HttpStatus.OK);
}

}
