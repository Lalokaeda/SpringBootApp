package vs.korzhina.SpringBootApp.service;

import org.springframework.stereotype.Service;

import vs.korzhina.SpringBootApp.model.Positions;

@Service
public interface IAnnualBonusService {

    double calculate(Positions position, int year, double salary, double bonus, int workDays);

}
