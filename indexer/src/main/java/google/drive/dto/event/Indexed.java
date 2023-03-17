package google.drive.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Indexed extends AbstractEvent {

    private Long id;
    private List&lt;String&gt; keywords;
    private String fileKey;

    public Indexed(){
        super();
    }
}