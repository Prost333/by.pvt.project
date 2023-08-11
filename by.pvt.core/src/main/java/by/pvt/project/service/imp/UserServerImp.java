package by.pvt.project.service.imp;

import by.pvt.project.domain.Role;
import by.pvt.project.domain.User;
import by.pvt.project.mapping.UserMapping;
import by.pvt.project.repository.UserRepository;
import by.pvt.project.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServerImp implements UserService {
    private UserRepository userRepository;
    private UserMapping userMapping;

    public UserServerImp(UserRepository userRepository, UserMapping userMapping) {
        this.userRepository = userRepository;
        this.userMapping = userMapping;
    }


    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public List<User> showAllUsers() {
        return null;
    }

    @Override
    public User findUserforID(int id) {
        return null;
    }

    @Override
    public User createUser(int id, String login, String password, String name, String surname) {
        return new User(id, login, password, name, surname, Role.CLIENT);
    }

    public User cheakPassword(String login, String password) {
        List<User> users = userRepository.update();
        Optional<User> user1 = users.stream().filter(user -> user.getPassword().equals(password)).findFirst();

        return user1.get();


    }
}
