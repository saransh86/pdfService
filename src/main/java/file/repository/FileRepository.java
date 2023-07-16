package file;

import file.model.File;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FileRepository extends MongoRepository<file.model.File, String> {

    public List<File> findAllByEmail(String email);
}
