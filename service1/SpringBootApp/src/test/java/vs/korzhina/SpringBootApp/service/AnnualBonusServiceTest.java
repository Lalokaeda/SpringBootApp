package vs.korzhina.SpringBootApp.service;

import org.junit.jupiter.api.Test;

import vs.korzhina.SpringBootApp.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnnualBonusServiceTest {
    @Test
    void testCalculate() {
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        int year=2024;

        double result = new AnnualBonusService().calculate(position, year, salary, bonus, workDays);

        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}
