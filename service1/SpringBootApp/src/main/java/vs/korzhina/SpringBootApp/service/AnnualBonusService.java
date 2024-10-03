package vs.korzhina.SpringBootApp.service;

import org.springframework.stereotype.Service;

import vs.korzhina.SpringBootApp.model.Positions;
import vs.korzhina.SpringBootApp.util.DaysInYearUtil;

@Service
public class AnnualBonusService implements IAnnualBonusService {

    @Override
    public double calculate(Positions position, int year, double salary, double bonus, int workDays) {
       return salary*bonus*DaysInYearUtil.calculateDaysInYear(year)*position.getPositionCoefficient()/workDays;
    }

}
