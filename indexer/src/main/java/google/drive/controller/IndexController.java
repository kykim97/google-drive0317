package google.drive.controller;

import google.drive.dto.entity.Index;
import google.drive.service.IndexService;
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
@RequestMapping(value = "/indices")
public class IndexController {

    @Autowired
    IndexService indexService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", indexService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Index getById(@PathVariable(value = "id") Long id) {
        Index index = indexService.getById(id);

        return index;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Index post(@RequestBody Index index) {
        indexService.save(index);

        return index;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void put(
        @PathVariable(value = "id") Long id,
        @RequestBody Index index
    ) {
        index.setId(id);
        indexService.update(index);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value = "id") Long id) {
        indexService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
