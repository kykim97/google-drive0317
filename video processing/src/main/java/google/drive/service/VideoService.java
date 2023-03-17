package google.drive.service;

import google.drive.dto.entity.Video;
import java.util.List;

public interface VideoService {
    public List<Video> getList();

    public void save(Video video);

    public Video getById(Long id);

    public void delete(Long id);

    public void update(Video video);
}
