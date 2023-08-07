package by.pvt.project.mapping;


import by.pvt.project.domain.User;
import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import by.pvt.project.repository.UserRepository;

public class UserMapping {
    public UserResponse responseUser(User user) {
        UserResponse userResponse = new UserResponse(user.getId(), user.getName() + " " + user.getSurname()
                , user.getLogin());
        return userResponse;
    }

    public User requestUser(UserRequest userRequest) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findUserforLogin(userRequest.getLogin());
    }
}

