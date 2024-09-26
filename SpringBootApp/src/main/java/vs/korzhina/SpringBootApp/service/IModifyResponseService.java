package vs.korzhina.SpringBootApp.service;

import org.springframework.stereotype.Service;

import vs.korzhina.SpringBootApp.model.Response;

@Service
public interface IModifyResponseService {

    Response modify(Response response);
}
