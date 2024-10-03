package vs.korzhina.SpringBootApp.service;

import vs.korzhina.SpringBootApp.model.Positions;

public interface IQuarterlyBonusService {
    double calculate(Positions position, int quarter, int year, double salary, double bonus, int workDays);
}
