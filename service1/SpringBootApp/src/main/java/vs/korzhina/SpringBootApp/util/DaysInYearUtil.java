package vs.korzhina.SpringBootApp.util;

public class DaysInYearUtil {

    public static int calculateDaysInYear(int year) {
        int daysInYear=0;
        if(year%100 == 0){
            if(year%400==0){
                daysInYear=366;
            }else{
            daysInYear=365;
            }
        }else if (year%4==0){
                daysInYear=366;
        } else{
            daysInYear=365;
        }
        return daysInYear;
    }

    public static int calculateDaysInQuarter(int quarter, int year){
        if ((calculateDaysInYear(year)==366 && quarter==1)|| quarter==2) {
            return 91;
        } else if (quarter==1){
            return 90;
        } else {
            return 92;
        }
    }
}
