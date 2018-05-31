package ainur.itis.kpfu.cartracker.CarTrackerServer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DriverData {
    @Id
    private Long id;
    @Column
    private Double latitude;
    @Column
    private Double longitude;
    @Column
    private Long time;

    public DriverData(Long time, Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
