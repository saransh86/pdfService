package file.model;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Test")
@Getter @Setter
public class File {
    @Id
    public String id;

    public byte[] fileDate;

    public String name;

    public String email;

    public Boolean isDirectory;

    public File() {}

    public File(String name, String email, Boolean isDirectory, byte ...fileDate){
        this.name = name;
        this.email = email;
        this.isDirectory = isDirectory;
        this.fileDate = (fileDate.length > 0)?fileDate:null;
    }

}
