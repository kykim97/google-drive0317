package google.drive.service.impl;

import google.drive.dto.entity.Index;
import google.drive.mapper.IndexMapper;
import google.drive.service.IndexService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Override
    public List<Index> getList() {
        List<Index> indexList = indexMapper.findList();

        return indexList;
    }

    @Override
    public void save(Index index) {
        indexMapper.save(index);
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // Indexed indexed = new Indexed();
        // BeanUtils.copyProperties(index, indexed);
        // indexed.publish(indexed.getId());

    }

    @Override
    public Index getById(Long id) {
        Index index = indexMapper.findOneById(id);

        return index;
    }

    @Override
    public void delete(Long id) {
        indexMapper.deleteById(id);
    }

    @Override
    public void update(Index index) {
        indexMapper.update(index);
    }
}
