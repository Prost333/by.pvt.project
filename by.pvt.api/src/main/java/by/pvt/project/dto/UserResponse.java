package by.pvt.project.dto;

public class UserResponse {
    private int id;
    private  String fullname;
    private String login;


    public UserResponse(int id, String fullname, String login) {
        this.id = id;
        this.fullname = fullname;
        this.login = login;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
