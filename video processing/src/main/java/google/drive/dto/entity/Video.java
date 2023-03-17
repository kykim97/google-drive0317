package google.drive.dto.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Video {

    private Long id;
    private String videoUrl;
    private Long fileId;
}
