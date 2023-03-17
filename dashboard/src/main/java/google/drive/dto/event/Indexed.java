package google.drive.dto.event;

import java.util.Date;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Indexed extends AbstractEvent {

    private Long id;
    private List&lt;String&gt; keywords;
    private String fileKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public List&lt;String&gt; getKeywords() {
        return keywords;
    }

    public void setKeywords(List&lt;String&gt; keywords) {
        this.keywords = keywords;
    }
    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }
}