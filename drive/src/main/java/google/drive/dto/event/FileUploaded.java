package google.drive.dto.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String name;
    private String type;
    private Long size;

    public FileUploaded() {
        super();
    }
}
