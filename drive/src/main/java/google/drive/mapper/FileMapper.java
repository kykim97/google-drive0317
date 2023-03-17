package google.drive.mapper;

import google.drive.dto.entity.File;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    public List<File> findList();

    public File findOneById(Long id);

    public void save(File file);

    public void update(File file);

    public void deleteById(Long id);
}
