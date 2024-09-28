package vs.korzhina.SpringBootApp.service;

import org.springframework.stereotype.Service;

import vs.korzhina.SpringBootApp.model.Request;

@Service
public interface IModifyRequestService {

    void modify(Request request);
}
