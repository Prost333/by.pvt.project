package by.pvt.project.mapping;


import by.pvt.project.domain.User;
import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import by.pvt.project.repository.UserRepository;
import by.pvt.project.service.imp.UserServerImp;

public class UserMapping {
    private UserServerImp userServerImp;
    public UserResponse responseUser(User user) {
        UserResponse userResponse = new UserResponse(user.getId(), user.getName() + " " + user.getSurname()
                , user.getLogin());
        return userResponse;
    }

    public User requestUser(UserRequest userRequest) {
        UserRepository userRepository=new UserRepository();
        User user=userRepository.update().stream().filter(user1 -> user1.getPassword().
                equals(userRequest.getPassword())).findFirst().orElseThrow();
        return  user;
    }
}

