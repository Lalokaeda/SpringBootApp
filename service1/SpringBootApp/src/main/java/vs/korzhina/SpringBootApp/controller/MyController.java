package vs.korzhina.SpringBootApp.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import vs.korzhina.SpringBootApp.model.Request;
import vs.korzhina.SpringBootApp.model.Response;
import vs.korzhina.SpringBootApp.service.IModifyRequestService;
import vs.korzhina.SpringBootApp.service.IModifyResponseService;
import vs.korzhina.SpringBootApp.service.IValidationService;
import vs.korzhina.SpringBootApp.util.ResponseUtil;

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
    private final IModifyRequestService modifyRequestService;
    private final IModifyRequestService modifyDateTimeRequestService;

    @Autowired
    public MyController(IValidationService validationService, 
                        @Qualifier("ModifySystemTimeResponseService") IModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemNameRequestService")IModifyRequestService modifyRequestService,
                        @Qualifier("ModifySystemTimeRequestService")IModifyRequestService modifyDateTimeRequestService) {
        this.validationService = validationService;
        this.modifyResponseService=modifyResponseService;
        this.modifyRequestService=modifyRequestService;
        this.modifyDateTimeRequestService= modifyDateTimeRequestService;
    }

@PostMapping(value="/feedback")
public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                            BindingResult bindingResult) {
    modifyDateTimeRequestService.modify(request);
    log.info("request: {}", request);                                            
    Response response = ResponseUtil.CreateResponse(request);
    log.info("response: {}", response);  


    response=ResponseUtil.Validate(validationService, request, bindingResult, response);
    switch (response.getErrorCode()) {
        case VALIDATION_EXCEPTION:
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        case UNSUPPORTED_EXCEPTION:
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        case UNKNOWN_EXCEPTION:    
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        default:
            break;
    }

    modifyResponseService.modify(response);
    modifyRequestService.modify(request);
    log.info("response after modification: {}", response);

    return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
}

}
