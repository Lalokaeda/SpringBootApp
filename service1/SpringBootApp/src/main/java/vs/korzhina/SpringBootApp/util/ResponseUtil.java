package vs.korzhina.SpringBootApp.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import vs.korzhina.SpringBootApp.exception.UnsupportedCodeException;
import vs.korzhina.SpringBootApp.exception.ValidationFailedException;
import vs.korzhina.SpringBootApp.model.Codes;
import vs.korzhina.SpringBootApp.model.ErrorCodes;
import vs.korzhina.SpringBootApp.model.ErrorMessages;
import vs.korzhina.SpringBootApp.model.Request;
import vs.korzhina.SpringBootApp.model.Response;
import vs.korzhina.SpringBootApp.service.IValidationService;

@Slf4j
public class ResponseUtil {

    public static Response CreateResponse(Request request){
       return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    }

    public static Response Validate(IValidationService validationService, @RequestBody Request request,
                                            BindingResult bindingResult, Response response){
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
        
        return response;
    }

    try {
        validationService.isValid(bindingResult);
        validationService.isUnsupportedCodeException(request);
    } catch (UnsupportedCodeException e) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNSUPPORTED);
        log.error("response unsupported exception: {}", response, e.getMessage());  
        return response;
    } catch (ValidationFailedException e) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
        response.setErrorMessage(ErrorMessages.VALIDATION);
        log.error("response validation exception: {}", response, e.getMessage()); 
        return response;
    } catch(Exception e){
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNKNOWN);
        log.error("response unknown exception: {}", response, e.getMessage()); 
        return response;
    }
    return response;
    }
}
