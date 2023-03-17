package google.drive.controller;

import google.drive.dto.entity.Video;
import google.drive.service.VideoService;
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
@RequestMapping(value = "/videos")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", videoService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Video getById(@PathVariable(value = "id") Long id) {
        Video video = videoService.getById(id);

        return video;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Video post(@RequestBody Video video) {
        videoService.save(video);

        return video;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void put(
        @PathVariable(value = "id") Long id,
        @RequestBody Video video
    ) {
        video.setId(id);
        videoService.update(video);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value = "id") Long id) {
        videoService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
