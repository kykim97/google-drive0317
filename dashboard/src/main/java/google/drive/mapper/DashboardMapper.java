package google.drive.mapper;

import google.drive.dto.entity.Dashboard;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DashboardMapper {
    public List<Dashboard> findList();

    public Dashboard findOneById(Long id);
}
