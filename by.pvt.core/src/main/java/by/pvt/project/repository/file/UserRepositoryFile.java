package by.pvt.project.repository.file;




import by.pvt.project.domain.User;
import by.pvt.project.repository.FileWorker;
import by.pvt.project.repository.serviceRep.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryFile extends FileWorker implements UserRepository {
    public static List<User> userList = new ArrayList<>();
    public static String way = "C:\\Project Java\\by.pvt.project\\by.pvt.core\\src\\main\\java\\by\\pvt\\project\\data\\Users.txt";

    public UserRepositoryFile() {
    }

    public void addUser(User user) {
        userList = update();
        userList.add(user);
        serializeObject(userList, way);
        saveUser();
    }

    public void deleteUser(User user) {
        userList = update();
        userList.remove(user);
        saveUser();
    }



    public List<User> showAllUsers() {
        userList= (List<User>) deserializeObject(way);
        System.out.println(deserializeObject(way));
        return userList;
    }




    public void saveUser() {
        serializeObject(userList, way);
        update();

    }

    public List<User> update() {
        Object object = deserializeObject(way);
        List<User> user = new ArrayList<>();
        if (object instanceof List<?>) {
            user = (List<User>) object;
        }
        return user;
    }

    @Override
    public String toString() {
        return "UserRepositoryFile{" +
                "userList=" + userList +
                '}';
    }


    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User findUserById(int id) {
        return null;
    }
}
