package google.drive.service.impl;

import google.drive.dto.entity.Dashboard;
import google.drive.mapper.DashboardMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    DashboardMapper dashboardMapper;

    @Override
    public List<Dashboard> getList() {
        List<Dashboard> dashboardList = dashboardMapper.findList();

        return dashboardList;
    }

    @Override
    public Dashboard getById(Long id) {
        Dashboard dashboard = dashboardMapper.findOneById(id);

        return dashboard;
    }
}
