package ainur.itis.kpfu.cartracker.CarTrackerServer.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.RoadsApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GoogleRoadService {

    @Value("${api.key}")
    private String apiKey;

    public List<LatLng> findRoadIntersections(List<LatLng> latLngs) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        List<GeocodingResult> geocodingResults = latLngs.stream()
                .map(latLng -> geocodeLatLng(context, latLng))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<GeocodingResult> intersections = new ArrayList<>();
        for (GeocodingResult curr : geocodingResults) {
            if (intersections.isEmpty()) {
                intersections.add(curr);
            } else {
                GeocodingResult last = intersections.get(intersections.size() - 1);
                if (!geocodingResultsEquals(curr, last)) {
                    intersections.add(curr);
                }
            }
        }

        return intersections.stream()
                .filter(sec -> sec.geometry != null)
                .map(sec -> sec.geometry.location)
                .collect(Collectors.toList());
    }

    private GeocodingResult geocodeLatLng(GeoApiContext context, LatLng latLng) {
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.newRequest(context)
                    .latlng(latLng)
                    .await();
        } catch (ApiException | InterruptedException | IOException e) {
            return null;
        }

        if (results.length > 0) {
            return results[0];
        }
        return null;
    }


    private boolean geocodingResultIsNotNull(GeocodingResult geocodingResult) {
        return geocodingResult != null && geocodingResult.formattedAddress != null;
    }

    private boolean geocodingResultsEquals(GeocodingResult first, GeocodingResult second) {
        return geocodingResultIsNotNull(first) && geocodingResultIsNotNull(second) &&
                !first.formattedAddress.equals(second.formattedAddress);
    }
}
