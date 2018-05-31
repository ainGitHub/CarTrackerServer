package ainur.itis.kpfu.cartracker.CarTrackerServer.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private Double score;

    @OneToOne
    private TripData tripData;

    public Driver() {
    }

    public Driver(String email, String name, TripData tripData, Double score) {
        this.email = email;
        this.name = name;
        this.tripData = tripData;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TripData getTripData() {
        return tripData;
    }

    public void setTripData(TripData tripData) {
        this.tripData = tripData;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getScore() {
        return score;
    }
}
