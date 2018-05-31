package ainur.itis.kpfu.cartracker.CarTrackerServer.domain;

import javax.persistence.*;

@Entity
public class AccidentData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer year;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private Integer regCode;

    @Column
    private String address;

    @Column
    private String regName;

    @Column
    private String crashTime;

    @Column
    private Integer dayOfWeek;

    public AccidentData() {}

    public AccidentData(Integer year, Double latitude, Double longitude, Integer regCode, String address, String regName, String crashTime) {
        this.year = year;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regCode = regCode;
        this.address = address;
        this.regName = regName;
        this.crashTime = crashTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getRegCode() {
        return regCode;
    }

    public void setRegCode(Integer regCode) {
        this.regCode = regCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getCrashTime() {
        return crashTime;
    }

    public void setCrashTime(String crashTime) {
        this.crashTime = crashTime;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
