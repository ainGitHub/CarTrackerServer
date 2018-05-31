package ainur.itis.kpfu.cartracker.CarTrackerServer.domain;

public enum AccidentRiskType {
    DANGER("Опасный"),
    MEAN("Средний"),
    SAFE("Безопасный");

    AccidentRiskType(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }
}
