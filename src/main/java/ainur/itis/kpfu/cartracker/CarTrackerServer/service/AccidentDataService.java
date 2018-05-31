package ainur.itis.kpfu.cartracker.CarTrackerServer.service;

import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.AccidentData;
import ainur.itis.kpfu.cartracker.CarTrackerServer.repository.AccidentDataRepository;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentDataService {
    @Autowired
    private AccidentDataRepository accidentDataRepository;

    public boolean existDataForYear(Integer year) {
        return accidentDataRepository.existsByYearEquals(year);
    }

    public List<AccidentData> saveAll(List<AccidentData> accidentDataList) {
       return (List<AccidentData>) accidentDataRepository.saveAll(accidentDataList);
    }

    public List<AccidentData> getAll() {
        return (List<AccidentData>) accidentDataRepository.findAll();
    }

    public Long accidentDataForTwoPointCount(LatLng firstPoint, LatLng secondPoint) {
        double maxX = Math.max(firstPoint.lat, secondPoint.lat);
        double minX = Math.min(firstPoint.lat, secondPoint.lat);

        double maxY = Math.max(firstPoint.lng, secondPoint.lng);
        double minY = Math.min(firstPoint.lng, secondPoint.lng);

        return accidentDataRepository.findAccidentDataInLine(minX, maxX, minY, maxY);
    }

    public int countAccidentForRegion(List<LatLng> intersections) {
        return getAll().size();
    }
}
