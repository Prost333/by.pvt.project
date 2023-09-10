package by.pvt.project.repository.BD;

import by.pvt.project.connector.PostgresqlConnector;
import by.pvt.project.domain.Good;
import by.pvt.project.domain.User;
import by.pvt.project.repository.serviceRep.GoodRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodRepositoryBD implements GoodRepository {
    public final PostgresqlConnector postgresqlConnector;
    private final String MAX_ID = "select max(id) from project.good";
    private final String Add_Person = "insert into project.good(name, id, type, price, code) values (?,?,?,?,?)";

    private final String DELITE = "delete from project.good where id=?";

    public GoodRepositoryBD(PostgresqlConnector postgresqlConnector) {
        this.postgresqlConnector = postgresqlConnector;
    }

    @Override
    public void addgood(Good good) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            var maxid = resultSet.getInt(1);
            PreparedStatement preparedStatement1 = connection.prepareStatement(Add_Person);
            preparedStatement1.setString(1, good.getName());
            preparedStatement1.setInt(2, ++maxid);
            preparedStatement1.setString(3, good.getType());
            preparedStatement1.setDouble(4, good.getPrice());
            preparedStatement1.setInt(5, good.getCode());
            preparedStatement1.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void deleteGood(Good good) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement(DELITE);
            preparedStatement.setInt(1, good.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Good> getAllGood() {
        List<Good> goodList = new ArrayList<>();
        try {
            Connection connection = postgresqlConnector.getConnector();
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from project.good");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String id = resultSet.getString(2);
                String type = resultSet.getString(3);
                String price = resultSet.getString(4);
                String code = resultSet.getString(5);
                Good good = new Good(name, Integer.valueOf(id), type, Double.valueOf(price), Integer.valueOf(code));
                goodList.add(good);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());

        }
        return goodList;
    }

    @Override
    public Good findGoodById(int id) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from project.good s where s.id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return new Good();
            }
            resultSet.next();
            String name = resultSet.getString(1);
            String type = resultSet.getString(3);
            String price = resultSet.getString(4);
            String code = resultSet.getString(5);
            Good good = new Good(name, Integer.valueOf(id), type, Double.valueOf(price), Integer.valueOf(code));
            return good;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void changeGoodName(int goodId, String name) {
        Connection connection = postgresqlConnector.getConnector();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update project.good\n" +
                    "set name=?\n" +
                    "where id=?");
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2, goodId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    public void changeGoodType(int goodId, String type) {
        Connection connection = postgresqlConnector.getConnector();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update project.good\n" +
                    "set type=?\n" +
                    "where id=?");
            preparedStatement.setString(1,type);
            preparedStatement.setInt(2, goodId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    public void changeGoodprice(int goodId, double price) {
        Connection connection = postgresqlConnector.getConnector();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update project.good\n" +
                    "set price=?\n" +
                    "where id=?");
            preparedStatement.setDouble(1,price);
            preparedStatement.setInt(2, goodId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
