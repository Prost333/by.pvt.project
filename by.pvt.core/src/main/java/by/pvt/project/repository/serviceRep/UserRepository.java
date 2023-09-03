package by.pvt.project.repository.serviceRep;

import by.pvt.project.domain.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);
    void deleteUser(User user);
    List<User> getAllUser();
    User findUserById(int id);

}
