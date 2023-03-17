package google.drive.dto.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Dashboard {

    private Long id;
    private Boolean isIndexed;
    private String videoUrl;
    private Long fileSize;
    private String fileName;
}
