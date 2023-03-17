package google.drive.service;

import google.drive.dto.entity.File;
import java.util.List;

public interface FileService {
    public List<File> getList();

    public void save(File file);

    public File getById(Long id);

    public void delete(Long id);

    public void update(File file);
}
