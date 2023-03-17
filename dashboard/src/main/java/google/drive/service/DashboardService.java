package google.drive.service;

import google.drive.dto.entity.Dashboard;
import java.util.List;

public interface DashboardService {
    public List<Dashboard> getList();

    public Dashboard getById(Long id);
}
