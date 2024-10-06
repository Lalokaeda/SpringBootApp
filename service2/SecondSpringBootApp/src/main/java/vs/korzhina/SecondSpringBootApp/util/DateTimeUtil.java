package vs.korzhina.SecondSpringBootApp.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static SimpleDateFormat getCustomFormat(){
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }

public static LocalDateTime getLocalDateTime(String date){
   return LocalDateTime.parse(date, DateTimeFormatter.ofPattern ("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
}
}
