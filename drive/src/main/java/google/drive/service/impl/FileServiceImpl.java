package google.drive.service.impl;

import google.drive.dto.entity.File;
import google.drive.mapper.FileMapper;
import google.drive.service.FileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public List<File> getList() {
        List<File> fileList = fileMapper.findList();

        return fileList;
    }

    @Override
    public void save(File file) {
        fileMapper.save(file);
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // FileUploaded fileUploaded = new FileUploaded();
        // BeanUtils.copyProperties(file, fileUploaded);
        // fileUploaded.publish(fileUploaded.getId());

    }

    @Override
    public File getById(Long id) {
        File file = fileMapper.findOneById(id);

        return file;
    }

    @Override
    public void delete(Long id) {
        fileMapper.deleteById(id);
    }

    @Override
    public void update(File file) {
        fileMapper.update(file);
    }
}
