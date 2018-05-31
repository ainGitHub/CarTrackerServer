package ainur.itis.kpfu.cartracker.CarTrackerServer;

import ainur.itis.kpfu.cartracker.CarTrackerServer.domain.AccidentData;
import ainur.itis.kpfu.cartracker.CarTrackerServer.service.AccidentDataService;
import freemarker.template.SimpleDate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class CarTrackerServerApplication {

	private static Integer year = 2017;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CarTrackerServerApplication.class, args);
		AccidentDataService accidentDataService = context.getBean(AccidentDataService.class);

		if (!accidentDataService.existDataForYear(year)) {
			List<AccidentData> accidentDataList = parseJsonFile();
			accidentDataService.saveAll(accidentDataList);
		}
	}

	private static List<AccidentData> parseJsonFile() {
		JSONParser jsonParser = new JSONParser();
		JSONArray data = null;
		try {
			data = (JSONArray) jsonParser.parse(
					new FileReader(
							ResourceUtils.getFile("classpath:static/2017-road-accident.json")));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		List<AccidentData> accidentDataList = new ArrayList<>();
		for (Object aData : data) {
			JSONObject obj = (JSONObject) aData;
			AccidentData accidentData = new AccidentData(year,
					Double.parseDouble((String) obj.get("latitude")),
					Double.parseDouble((String) obj.get("longitutde")),
					Integer.parseInt((String) obj.get("reg_code")),
					(String) obj.get("address"),
					(String) obj.get("reg_name"),
					(String) obj.get("crash_time"));
			accidentDataList.add(accidentData);
		}

		return accidentDataList;
	}
}
