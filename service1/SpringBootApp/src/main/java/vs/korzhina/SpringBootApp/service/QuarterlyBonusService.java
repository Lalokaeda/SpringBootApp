package vs.korzhina.SpringBootApp.service;

import vs.korzhina.SpringBootApp.model.Positions;
import vs.korzhina.SpringBootApp.util.DaysInYearUtil;

public class QuarterlyBonusService implements IQuarterlyBonusService{

    @Override
    public double calculate(Positions position, int quarter, int year, double salary, double bonus, int workDays) {
        if(position.isManager()){
            return salary*bonus*DaysInYearUtil.calculateDaysInQuarter(quarter, year)*position.getPositionCoefficient()/workDays;
        }
        else
        throw new UnsupportedOperationException("Сотрудник не является менеджером!");
    }

}
