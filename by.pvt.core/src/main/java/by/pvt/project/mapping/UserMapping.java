package by.pvt.project.mapping;


import by.pvt.project.domain.User;
import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import by.pvt.project.repository.file.UserRepositoryFile;
import by.pvt.project.service.imp.UserServerImp;

public class UserMapping {
    private UserServerImp userServerImp;
    public UserResponse responseUser(User user) {
        UserResponse userResponse = new UserResponse(user.getId(), user.getName() + " " + user.getSurname()
                , user.getLogin());
        return userResponse;
    }

    public User requestUser(UserRequest userRequest) {

        User user= new User();
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        return  user;
    }
}

