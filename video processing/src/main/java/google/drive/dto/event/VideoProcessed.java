package google.drive.dto.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class VideoProcessed extends AbstractEvent {

    private Long id;
    private String videoUrl;
    private Long fileId;

    public VideoProcessed() {
        super();
    }
}
