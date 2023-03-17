package google.drive.mapper;

import google.drive.dto.entity.Index;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IndexMapper {
    public List<Index> findList();

    public Index findOneById(Long id);

    public void save(Index index);

    public void update(Index index);

    public void deleteById(Long id);
}
