package ainur.itis.kpfu.cartracker.CarTrackerServer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Locale;

@Entity
public class TripData {
    @Id
    private Long id;
    @Column
    private Double maxSpeed;
    @Column
    private Double durationTime;
    @Column
    private Long startTime;
    @Column
    private Integer hardAccCount;
    @Column
    private Integer hardDeccCount;
    @Column
    private Integer hardLeftTurnCount;
    @Column
    private Integer hardRightTurnCount;
    @Column
    private Integer tripScore;
    @Column
    private Integer roadScore;

    public TripData() {

    }

    public TripData(Double maxSpeed, Double durationTime, Long startTime) {
        this.maxSpeed = maxSpeed;
        this.durationTime = durationTime;
        this.startTime = startTime;
    }

    public TripData(Double maxSpeed, Double durationTime, Long startTime, Integer hardAccCount, Integer hardDeccCount, Integer hardLeftTurnCount, Integer hardRightTurnCount) {
        this.maxSpeed = maxSpeed;
        this.durationTime = durationTime;
        this.startTime = startTime;
        this.hardAccCount = hardAccCount;
        this.hardDeccCount = hardDeccCount;
        this.hardLeftTurnCount = hardLeftTurnCount;
        this.hardRightTurnCount = hardRightTurnCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Double durationTime) {
        this.durationTime = durationTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Integer getHardAccCount() {
        return hardAccCount;
    }

    public void setHardAccCount(Integer hardAccCount) {
        this.hardAccCount = hardAccCount;
    }

    public Integer getHardDeccCount() {
        return hardDeccCount;
    }

    public void setHardDeccCount(Integer hardDeccCount) {
        this.hardDeccCount = hardDeccCount;
    }

    public Integer getHardLeftTurnCount() {
        return hardLeftTurnCount;
    }

    public void setHardLeftTurnCount(Integer hardLeftTurnCount) {
        this.hardLeftTurnCount = hardLeftTurnCount;
    }

    public Integer getHardRightTurnCount() {
        return hardRightTurnCount;
    }

    public void setHardRightTurnCount(Integer hardRightTurnCount) {
        this.hardRightTurnCount = hardRightTurnCount;
    }

    public Integer getTripScore() {
        return tripScore;
    }

    public void setTripScore(Integer tripScore) {
        this.tripScore = tripScore;
    }

    public Integer getRoadScore() {
        return roadScore;
    }

    public void setRoadScore(Integer roadScore) {
        this.roadScore = roadScore;
    }
}
