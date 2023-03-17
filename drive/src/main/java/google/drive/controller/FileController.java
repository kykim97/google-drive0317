package google.drive.controller;

import google.drive.dto.entity.File;
import google.drive.service.FileService;
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
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(
        value = "/delete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public void delete(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /file/delete  called #####");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", fileService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public File getById(@PathVariable(value = "id") Long id) {
        File file = fileService.getById(id);

        return file;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public File post(@RequestBody File file) {
        fileService.save(file);

        return file;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void put(
        @PathVariable(value = "id") Long id,
        @RequestBody File file
    ) {
        file.setId(id);
        fileService.update(file);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value = "id") Long id) {
        fileService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
