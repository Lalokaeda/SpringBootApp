package vs.korzhina.SecondSpringBootApp.service;

import org.springframework.stereotype.Service;

import vs.korzhina.SecondSpringBootApp.model.Response;

@Service
public interface IModifyResponseService {

    Response modify(Response response);
}
