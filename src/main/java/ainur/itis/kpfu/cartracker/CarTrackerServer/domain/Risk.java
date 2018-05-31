package ainur.itis.kpfu.cartracker.CarTrackerServer.domain;

public class Risk {

    double averageRiskValue;
    double dispersionRiskValue;
    private AccidentRiskType accidentRiskType;

    public Risk(double averageRiskValue, double dispersionRiskValue, AccidentRiskType accidentRiskType) {
        this.averageRiskValue = averageRiskValue;
        this.dispersionRiskValue = dispersionRiskValue;
        this.accidentRiskType = accidentRiskType;
    }

    public double getAverageRiskValue() {
        return averageRiskValue;
    }

    public void setAverageRiskValue(double averageRiskValue) {
        this.averageRiskValue = averageRiskValue;
    }

    public double getDispersionRiskValue() {
        return dispersionRiskValue;
    }

    public void setDispersionRiskValue(double dispersionRiskValue) {
        this.dispersionRiskValue = dispersionRiskValue;
    }

    public AccidentRiskType getAccidentRiskType() {
        return accidentRiskType;
    }

    public void setAccidentRiskType(AccidentRiskType accidentRiskType) {
        this.accidentRiskType = accidentRiskType;
    }
}
