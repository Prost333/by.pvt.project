package by.pvt.project.repository.BD;

import by.pvt.project.connector.PostgresqlConnector;
import by.pvt.project.domain.Role;
import by.pvt.project.domain.User;
import by.pvt.project.repository.serviceRep.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryBD implements UserRepository {
    public final PostgresqlConnector postgresqlConnector;
    private final String MAX_ID = "select max(id) from project.user";
    private final String Add_Person = "insert into project.user(id, name, surname, password, login, Role) values (?,?,?,?,?,?)";

    private final String DELITE = "delete from project.user where id=?";

    public UserRepositoryBD(PostgresqlConnector postgresqlConnector) {
        this.postgresqlConnector = postgresqlConnector;
    }

    @Override
    public void addUser(User user) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            var maxid = resultSet.getInt(1);
            PreparedStatement preparedStatement1 = connection.prepareStatement(Add_Person);
            preparedStatement1.setInt(1, ++maxid);
            preparedStatement1.setString(2, user.getName());
            preparedStatement1.setString(3, user.getSurname());
            preparedStatement1.setString(4, user.getPassword());
            preparedStatement1.setString(5, user.getLogin());
            preparedStatement1.setString(6, user.getRole().name());
            preparedStatement1.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void deleteUser(User user) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement(DELITE);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }


    }

    @Override
    public List<User> getAllUser() {
        List<User> personList = new ArrayList<>();
        try {
            Connection connection = postgresqlConnector.getConnector();
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from project.user");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String password = resultSet.getString(4);
                String login = resultSet.getString(5);
                String role = resultSet.getString(6);
                if (role.equals("Admin")) {
                    User person = new User(Integer.valueOf(id), name, surname, password, login, Role.ADMIN);
                    personList.add(person);
                }else {
                    User person = new User(Integer.valueOf(id), name, surname, password, login, Role.CLIENT);
                    personList.add(person);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return personList;
    }

    @Override
    public User findUserById(int id) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from project.user s where s.id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return new User();
            }
            resultSet.next();
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            String password = resultSet.getString(4);
            String login = resultSet.getString(5);
            String role = resultSet.getString(5);
            User person = new User(Integer.valueOf(id), name, surname, password, login, Role.CLIENT);
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
