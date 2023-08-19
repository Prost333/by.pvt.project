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

    public UserServerImp() {
    }

    public UserServerImp(UserRepository userRepository, UserMapping userMapping) {
        this.userRepository = userRepository;
        this.userMapping = userMapping;
    }


    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    @Override
    public List<User> showAllUsers() {
        return userRepository.showAllUsers();
    }
    public User findUserByLogin(String login) {
        List<User> users = userRepository.update();
        Optional<User> users2 = users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
        try {
            if (users2.isEmpty()) {
                System.out.println("Такого Login не существует");
            } else {
                System.out.println(users2.get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users2.get();
    }

    @Override
    public User findUserByID(int id) {
        List<User> users = userRepository.update();
        Optional<User> users2 = users.stream().filter(user -> user.getId() == id).findFirst();
        try {
            if (users2.isEmpty()) {
                System.out.println("Такого id не существует");
            } else {
                System.out.println(users2.get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users2.get();
    }

    @Override
    public User createUser(int id, String login, String password, String name, String surname) {
        User user= new User(id, login, password, name, surname, Role.CLIENT);
        if (countlist()==0){
            user.setRole(Role.ADMIN);
        }
        return user;
    }

    public User cheakPassword(String login, String password) {
        List<User> users = userRepository.update();
        Optional<User> user1 = users.stream().filter(user -> user.getPassword().equals(password)).findFirst();

        return user1.get();
    }
    public  int countlist(){
        return userRepository.update().size();
    }

}
