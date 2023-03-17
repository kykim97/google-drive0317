package google.drive.domain;

import google.drive.DriveApplication;
import google.drive.domain.FileUploaded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private Long size;

    private String status;

    @PostPersist
    public void onPostPersist() {
        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }

    public void delete() {
        FileDeleted fileDeleted = new FileDeleted(this);
        fileDeleted.publishAfterCommit();
    }
}
