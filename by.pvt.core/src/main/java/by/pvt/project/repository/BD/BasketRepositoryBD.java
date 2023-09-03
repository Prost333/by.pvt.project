package by.pvt.project.repository.BD;

import by.pvt.project.connector.PostgresqlConnector;
import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.repository.serviceRep.BasketRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketRepositoryBD implements BasketRepository {
    public final PostgresqlConnector postgresqlConnector;
    private final String MAX_ID = "select max(id) from project.basket";
    private final String Add_Person = "insert into project.basket(id, user_id, order_id, price, count) values (?,?,?,?,?)";

    private final String DELITE = "delete from project.basket where id=?";


    public BasketRepositoryBD(PostgresqlConnector postgresqlConnector) {
        this.postgresqlConnector = postgresqlConnector;}

        @Override
        public void addBasket (Basket basket){
            try {
                Connection connection = postgresqlConnector.getConnector();
                PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                var maxid = resultSet.getInt(1);
                PreparedStatement preparedStatement1 = connection.prepareStatement(Add_Person);
                preparedStatement1.setInt(1, ++maxid);
                preparedStatement1.setInt(2, basket.getUserId());
                preparedStatement1.setInt(3, basket.getOrderid());
                preparedStatement1.setDouble(4, basket.getPrice());
                preparedStatement1.setDouble(5, basket.getCount());
                preparedStatement1.execute();
            } catch (
                    SQLException e) {
                throw new RuntimeException(e.getMessage());
            }

        }

        @Override
        public void deleteBasket (Basket basket){
            try {
                Connection connection = postgresqlConnector.getConnector();
                PreparedStatement preparedStatement = connection.prepareStatement(DELITE);
                preparedStatement.setInt(1, basket.getId());
                preparedStatement.executeQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }

        }

        @Override
        public Basket findBasketById ( int id){
            try {
                Connection connection = postgresqlConnector.getConnector();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from project.order s where s.id=?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet == null) {
                    return new Basket();
                }
                resultSet.next();
                String userId = resultSet.getString(2);
                String orderId = resultSet.getString(3);
                String count = resultSet.getString(4);
                String price = resultSet.getString(5);
                Basket basket=new Basket(id,Integer.valueOf(userId),Double.parseDouble(price),
                        Integer.valueOf(orderId),Integer.valueOf(count));
                return basket;
               } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override
        public List<Basket> getAllBasket () {
            List<Basket> basketList = new ArrayList<>();
            try {
                Connection connection = postgresqlConnector.getConnector();
                Statement statement = connection.createStatement();
                statement.executeQuery("select * from project.order");
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    String userId = resultSet.getString(2);
                    String orderId = resultSet.getString(3);
                    String count = resultSet.getString(4);
                    String price = resultSet.getString(5);
                    Basket basket=new Basket(Integer.valueOf(id),Integer.valueOf(userId),Double.parseDouble(price),
                            Integer.valueOf(orderId),Integer.valueOf(count));
                    basketList.add(basket);
                    }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
            return basketList;
        }
    }
