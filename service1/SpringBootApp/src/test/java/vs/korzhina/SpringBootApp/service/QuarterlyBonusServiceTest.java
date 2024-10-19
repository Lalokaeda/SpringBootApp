package vs.korzhina.SpringBootApp.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import vs.korzhina.SpringBootApp.model.Positions;

public class QuarterlyBonusServiceTest {
    @Test
    void testCalculate() {
         Positions position = Positions.PM;
        double bonus = 2.1;
        int workDays = 74;
        double salary = 150000.00;
        int year=2024;
        int quarter=2;

        double result = new QuarterlyBonusService().calculate(position, quarter, year, salary, bonus, workDays);

        double expected = 1123358.1081081082;
        assertThat(result).isEqualTo(expected);
    }
}
