package vs.korzhina.SpringBootApp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    //Уникальный идентфикатор сообщения
    private String uid;

    //Уникальный идентификатор операции
    private String operationUid;

    //Время создания сообщения
    private String systemTime;

    //Код ответа
    private Codes code;

    //Годовой бонус
    private Double annualBonus;

    //Код ошибки
    private ErrorCodes errorCode;

    //Сообщение об ошибке
    private ErrorMessages errorMessage;
 
}
