package vs.korzhina.SecondSpringBootApp.model;


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

    @Max(100000)
    @Min(1)
    private int communicationId;

    private int templateId;

    private int productCode;
    
    private int smsCode;

    @Override
    public String toString() {
        return "{"+
                "uid=" + uid + '\''+
                ", operationUid=" + operationUid + '\''+
                ", systemName=" + systemName + '\''+
                ", systemTime=" + systemTime + '\''+
                ", source=" + source + '\''+
                ", communicationId=" + communicationId + '\''+
                ", templateId=" + templateId + '\''+
                ", productCode=" + productCode + '\''+
                ", smsCode=" + smsCode + '\''+
                "}";
    }

}
