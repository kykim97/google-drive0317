package google.drive.dto.entity;

import java.util.Date;
import lombok.Data;
@Data
public class Index{
    private Long id;
    private List&lt;String&gt; keywords;
    private String fileKey;

    
}