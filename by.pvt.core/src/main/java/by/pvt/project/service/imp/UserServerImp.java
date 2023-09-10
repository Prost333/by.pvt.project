package by.pvt.project.service.imp;

import by.pvt.project.domain.Role;
import by.pvt.project.domain.User;
import by.pvt.project.mapping.UserMapping;
import by.pvt.project.repository.BD.UserRepositoryBD;
import by.pvt.project.repository.file.UserRepositoryFile;
import by.pvt.project.repository.serviceRep.UserRepository;
import by.pvt.project.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServerImp implements UserService {
    private UserRepository userRepositoryDB;
    private UserMapping userMapping;

    public UserServerImp() {
    }

    public UserServerImp(UserRepositoryBD userRepositoryBD, UserMapping userMapping) {
        this.userRepositoryDB = userRepositoryBD;
        this.userMapping = userMapping;
    }


    @Override
    public User addUser(User user) {
        userRepositoryDB.addUser(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        userRepositoryDB.deleteUser(user);
    }

    @Override
    public List<User> showAllUsers() {
        return userRepositoryDB.getAllUser();
    }

    public User findUserByLogin(String login) {
        User user= userRepositoryDB.findUserByLogin(login);
        return user;
    }

    @Override
    public User findUserByID(int id) {
        User user=userRepositoryDB.findUserById(id);
        return user;
    }
    @Override
    public User createUser(int id, String login, String password, String name, String surname) {
        User user= new User(id, login, password, name, surname, Role.CLIENT);

        return user;
    }

    public User cheakPassword(String login, String password) {
        return userRepositoryDB.findUserByLoginandPassword(login,password);
    }
    @Override
    public List<User> userlist() {
        return userRepositoryDB.getAllUser();
    }


}
