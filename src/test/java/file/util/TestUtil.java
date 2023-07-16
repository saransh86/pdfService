package file.util;

import file.User;
import file.model.File;
import org.bson.types.Binary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<File> createSingleFiles() throws IOException {
        List<File> filteredList = new ArrayList<>();
        filteredList.add(createFile1());
        return filteredList;
    }

    public static List<File> createMultipleFiles() throws IOException {
        List<File> filteredList = new ArrayList<>();
        filteredList.add(createFile1());
        filteredList.add(createFile2());
        return filteredList;

    }
    public static List<User> createFilteredUser(){
        List<User> filteredUser = new ArrayList<User>();
        filteredUser.add(createUser1());
        filteredUser.add((createUser2()));
        return filteredUser;
    }

    public static File createFile1() throws IOException {
        File file1 = new File();
        file1.setEmail("user1@test.com");
        file1.setFileDate(new Binary(Files.readAllBytes(Paths.get("./src/test/java/file/util/text2.png"))).getData());
        file1.setName("text1.txt");
        file1.setIsDirectory(false);
        return file1;
    }
    public static File createFile2() throws IOException {
        File file1 = new File();
        file1.setEmail("user3@test.com");
        file1.setFileDate(new Binary(Files.readAllBytes(Paths.get("./src/test/java/file/util/text2.png"))).getData());
        file1.setName("text1.txt");
        file1.setIsDirectory(false);
        return file1;
    }

    public static User createUser1(){
        User user1 = new User();
        user1.setId("1");
        user1.setEmail("user1@test.com");
        user1.setToken("token1");
        user1.setVerifyRegistration(true);
        user1.setPassword("password1");
        user1.setIsAdmin(false);
        return user1;
    }
    public static User createUser2(){
        User user2 = new User();
        user2.setId("2");
        user2.setEmail("user2@test.com");
        user2.setToken("token2");
        user2.setVerifyRegistration(true);
        user2.setPassword("password2");
        user2.setIsAdmin(false);
        return user2;
    }

    public static List<File> createTextFile() throws IOException {
        File file1 = new File();
        file1.setEmail("user3@test.com");
        file1.setFileDate(new Binary(Files.readAllBytes(Paths.get("./src/test/java/file/util/text.txt"))).getData());
        file1.setName("text.txt");
        file1.setIsDirectory(false);
        List<File> filteredList = new ArrayList<>();
        filteredList.add(file1);
        return filteredList;
    }

}
