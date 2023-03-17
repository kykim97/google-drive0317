package google.drive.service;

import google.drive.dto.entity.Index;
import java.util.List;

public interface IndexService {
    public List<Index> getList();

    public void save(Index index);

    public Index getById(Long id);

    public void delete(Long id);

    public void update(Index index);
}
