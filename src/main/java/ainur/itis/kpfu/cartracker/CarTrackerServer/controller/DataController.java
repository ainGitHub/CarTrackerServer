package ainur.itis.kpfu.cartracker.CarTrackerServer.controller;
import ainur.itis.kpfu.cartracker.CarTrackerServer.service.ClientFileParserService;
import ainur.itis.kpfu.cartracker.CarTrackerServer.service.DriverDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;


@Controller
public class DataController {
    private static final String OK = "ok";
    private static final String FAILURE = "failure";
    private static final String FILE_NOT_FOUND = "file_not_found";

    @Autowired
    private ClientFileParserService fileParserService;

    @Autowired
    private DriverDataService driverDataService;

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.put("drivers", driverDataService.allDrivers());
        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public String data(@RequestParam("file") MultipartFile multipartFile) {
        try {
            fileParserService.parse(multipartFile);
            return OK;
        } catch (FileNotFoundException e) {
            return FILE_NOT_FOUND;
        } catch (IOException e) {
            return FAILURE;
        }
    }
}
