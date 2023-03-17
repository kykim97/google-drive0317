package google.drive.controller;

import google.drive.dto.Dashboard;
import google.drive.service.DashboardService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dashboards")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", dashboardService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Dashboard getById(@PathVariable(value = "id") Long id) {
        Dashboard dashboard = dashboardService.getById(id);

        return dashboard;
    }
}
