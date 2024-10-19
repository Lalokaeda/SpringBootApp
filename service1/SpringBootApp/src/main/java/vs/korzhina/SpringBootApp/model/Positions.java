package vs.korzhina.SpringBootApp.model;

import lombok.Getter;

@Getter
public enum Positions {

    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, false),
    MANAGER_DEVISION(3.0, true),
    SENIOR_MANAGER(3.5, true),
    PM(2.9, true);


    Positions(double positionCoefficient, boolean isManager) {
        this.positionCoefficient = positionCoefficient;
        this.isManager=isManager;
    }

    private final double positionCoefficient;
    private final boolean isManager;
}
