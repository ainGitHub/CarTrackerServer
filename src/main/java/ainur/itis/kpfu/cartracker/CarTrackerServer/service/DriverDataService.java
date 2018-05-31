package ainur.itis.kpfu.cartracker.CarTrackerServer.service;

import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.Driver;
import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.DriverData;
import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.TripData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class DriverDataService {
    static Driver driver = new Driver();
    static {
        driver.setName("Айнур");
        driver.setEmail("ainur6969@gmail.com");
        driver.setScore(8.5);
        driver.setTripData(new TripData(100d, 34d, new Date(2018, 3, 4).getTime(),
                3, 4, 2, 5));
        driver.getTripData().setTripScore(9);
        driver.getTripData().setRoadScore(8);
    }

    static Driver driver2 = new Driver();
    static {
        driver2.setName("Иван");
        driver2.setEmail("ivantest@gmail.com");
        driver2.setScore(9.7);
    }

    public void saveAll(List<DriverData> driverDataList, TripData tripData) {
    }

    public List<Driver> allDrivers() {
        return new ArrayList<Driver>() {{add(driver); add(driver2);}};
    }
}
