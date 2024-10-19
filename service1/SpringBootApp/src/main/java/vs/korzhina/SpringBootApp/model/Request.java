package vs.korzhina.SpringBootApp.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    //Уникальный идентификатор сообщения
    @NotBlank
    @Size(max=32)
    private String uid;
    
    //Уникальный идентификатор операции
    @NotBlank
    @Size(max=32)
    private String operationUid;

    //Имя системы отправителя
    private String systemName;

    //Время создания сообщения
    @NotBlank
    private String systemTime;

    //Наименование ресурса
    private String source;

    //Должность
    private Positions position;

    //Зарплата
    private Double salary;

    //Бонус
    private Double bonus;

    //Количество рабочих часов
    private Integer workDays;

    //Уникальный идентификатор коммуникации
    @Max(100000)
    @Min(1)
    private Integer communicationId;

    //Уникальный идентификатор шаблона
    private Integer templateId;

    //Код продукта
    private Integer productCode;
    
    //Смс код
    private Integer smsCode;

    @Override
    public String toString() {
        return "{"+
                "uid=" + uid + '\''+
                ", operationUid=" + operationUid + '\''+
                ", systemName=" + systemName + '\''+
                ", systemTime=" + systemTime + '\''+
                ", source=" + source + '\''+
                ", position=" + position + '\''+
                ", salary=" + salary + '\''+
                ", bonus=" + bonus + '\''+
                ", workDays=" + workDays + '\''+
                ", communicationId=" + communicationId + '\''+
                ", templateId=" + templateId + '\''+
                ", productCode=" + productCode + '\''+
                ", smsCode=" + smsCode + '\''+
                "}";
    }

}
