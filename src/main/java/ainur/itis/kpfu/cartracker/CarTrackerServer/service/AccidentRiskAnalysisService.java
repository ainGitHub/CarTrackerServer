package ainur.itis.kpfu.cartracker.CarTrackerServer.service;

import ainur.itis.kpfu.cartracker.CarTrackerServer.Utils;
import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.AccidentRiskType;
import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.Risk;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class AccidentRiskAnalysisService {
    @Autowired
    private AccidentDataService accidentDataService;
    @Autowired
    private GoogleRoadService googleRoadService;

    private final int SCALE = 10;

    public Risk calculateRisk(List<LatLng> latLngs) {
        List<LatLng> intersections = googleRoadService.findRoadIntersections(latLngs);
        Integer countAllAccidentForRegion = accidentDataService.countAccidentForRegion(intersections);

        double[] portionOfAccident = new double[intersections.size() - 1];
        for (int i = 1; i < intersections.size(); i++) {
            LatLng last = intersections.get(i - 1);
            LatLng curr = intersections.get(i);

            long count = accidentDataService.accidentDataForTwoPointCount(last, curr);

            portionOfAccident[i - 1] = (double) count/countAllAccidentForRegion;
            portionOfAccident[i - 1] = portionOfAccident[i - 1] / Utils.distance(last.lat, last.lng, curr.lat, curr.lng);
        }

        Double portion = DoubleStream.of(portionOfAccident).sum()/portionOfAccident.length;
        Double risk = DoubleStream.of(portionOfAccident)
                .map(p -> Math.pow(p - portion, 2))
                .sum()/portionOfAccident.length;
        return new Risk(portion * SCALE, risk * SCALE,
                translateRisk(portion * SCALE, risk * SCALE));
    }

    private AccidentRiskType translateRisk(double average, double risk) {
        if (average >= 0 && average <= 3.7 && risk >= 0 && risk <= 4.65) {
            return AccidentRiskType.SAFE;
        }

        if (average > 3.7 && average <= 6.3 && risk > 4.65 && risk <= 6.23) {
            return AccidentRiskType.MEAN;
        }

        return AccidentRiskType.DANGER;
    }
}
