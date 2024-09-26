package vs.korzhina.SpringBootApp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vs.korzhina.SpringBootApp.model.Response;
import vs.korzhina.SpringBootApp.util.DateTimeUtil;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements IModifyResponseService{

    @Override
    public Response modify(Response response) {
       response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
       return response;
    }

}
