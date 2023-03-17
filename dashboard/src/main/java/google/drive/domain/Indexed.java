package google.drive.domain;

import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Indexed extends AbstractEvent {

    private Long id;
    private List<String> keywords;
    private String fileKey;
}
