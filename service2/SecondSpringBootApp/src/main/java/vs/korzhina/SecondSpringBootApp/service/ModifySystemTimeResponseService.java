package vs.korzhina.SecondSpringBootApp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vs.korzhina.SecondSpringBootApp.model.Response;
import vs.korzhina.SecondSpringBootApp.util.DateTimeUtil;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements IModifyResponseService{

    @Override
    public Response modify(Response response) {
       response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
       return response;
    }

}
