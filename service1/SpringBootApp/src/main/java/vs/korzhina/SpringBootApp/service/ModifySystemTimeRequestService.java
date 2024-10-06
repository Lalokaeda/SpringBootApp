package vs.korzhina.SpringBootApp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vs.korzhina.SpringBootApp.model.Request;
import vs.korzhina.SpringBootApp.util.DateTimeUtil;

@Service
@Qualifier("ModifySystemTimeRequestService")
public class ModifySystemTimeRequestService implements IModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

        HttpEntity<Request> httpEntity = new HttpEntity<Request>(request);
        
        new RestTemplate().exchange("http://localhost:8084/feedback",
                                    HttpMethod.POST,
                                    httpEntity,
                                    new ParameterizedTypeReference<Request>() {
                                        
                                    });
    }
}
