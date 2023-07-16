package file;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Getter @Setter
public class User {

    @Id
    public String id;

    public String email;
    public String username;
    public String password;
    public Boolean isAdmin;
    public Boolean verifyRegistration;
    public String token;

    public User() {}

    public User(String email, String username, String password, Boolean isAdmin, Boolean verifyRegistration, String token) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.verifyRegistration = verifyRegistration;
        this.token = token;
    }
}
