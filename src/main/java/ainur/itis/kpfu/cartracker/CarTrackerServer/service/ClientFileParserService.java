package ainur.itis.kpfu.cartracker.CarTrackerServer.service;

import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.DriverData;
import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.TripData;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientFileParserService {
    @Autowired
    private DriverDataService driverDataService;

    public void parse(MultipartFile file) throws FileNotFoundException, IOException {
        if (file == null || !file.isEmpty()) {
            List<DriverData> driverDataList = new ArrayList<>();
            TripData tripData = null;

            try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                tripData = parseTripData(br.readLine());

                String line;
                while ((line = br.readLine()) != null) {
                    String[] tokens = line.split(",");
                    Long time = Long.parseLong(tokens[0]);
                    Double latitude = Double.parseDouble(tokens[1]);
                    Double longitude = Double.parseDouble(tokens[2]);
                    driverDataList.add(new DriverData(time, latitude, longitude));
                }
            } catch (IOException e) {
                throw e;
            }

            driverDataService.saveAll(driverDataList, tripData);
        } else {
            throw new FileNotFoundException();
        }
    }

    private TripData parseTripData(String tripHeader) {
        String[] tokens = tripHeader.split(",");
        return new TripData(Double.parseDouble(tokens[0]),
                                         Double.parseDouble(tokens[1]),
                                         Long.parseLong(tokens[2]));
    }
}
