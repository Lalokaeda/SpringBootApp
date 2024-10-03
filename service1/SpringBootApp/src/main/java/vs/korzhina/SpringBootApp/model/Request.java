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

    @NotBlank
    @Size(max=32)
    private String uid;
    
    
    @NotBlank
    @Size(max=32)
    private String operationUid;


    private String systemName;

    @NotBlank
    private String systemTime;

    private String source;

    private Positions position;

    private Double salary;

    private Double bonus;

    private Integer workDays;

    @Max(100000)
    @Min(1)
    private Integer communicationId;

    private Integer templateId;

    private Integer productCode;
    
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
