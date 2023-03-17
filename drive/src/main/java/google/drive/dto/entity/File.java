package google.drive.dto.entity;

import java.util.Date;
import lombok.Data;

@Data
public class File {

    private Long id;
    private String name;
    private String type;
    private Long size;
    private String status;
}
