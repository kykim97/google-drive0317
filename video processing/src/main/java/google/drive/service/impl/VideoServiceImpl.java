package google.drive.service.impl;

import google.drive.dto.entity.Video;
import google.drive.mapper.VideoMapper;
import google.drive.service.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> getList() {
        List<Video> videoList = videoMapper.findList();

        return videoList;
    }

    @Override
    public void save(Video video) {
        videoMapper.save(video);
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // VideoProcessed videoProcessed = new VideoProcessed();
        // BeanUtils.copyProperties(video, videoProcessed);
        // videoProcessed.publish(videoProcessed.getId());

    }

    @Override
    public Video getById(Long id) {
        Video video = videoMapper.findOneById(id);

        return video;
    }

    @Override
    public void delete(Long id) {
        videoMapper.deleteById(id);
    }

    @Override
    public void update(Video video) {
        videoMapper.update(video);
    }
}
