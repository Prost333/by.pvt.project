package by.pvt.project.service;




import by.pvt.project.domain.User;

import java.util.List;

public interface UserService {
 User addUser(User user);

 void deleteUser(User user);
 List<User> showAllUsers();
 User findUserforID(int id);
 User createUser (int id, String login, String password, String name, String surname);

}

