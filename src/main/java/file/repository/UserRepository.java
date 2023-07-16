package file;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<file.User, String>{

    public file.User findByUsername(String username);
    public file.User findByEmail(String email);
}
