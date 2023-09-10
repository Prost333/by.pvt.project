package by.pvt.project.repository.BD;

import by.pvt.project.connector.PostgresqlConnector;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.repository.serviceRep.OrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryBD implements OrderRepository {
    public final PostgresqlConnector postgresqlConnector;
    private final String MAX_ID = "select max(id) from project.order";
    private final String Add_Person = "insert into project.order(id, user_id, good_id, count, price, status) values (?,?,?,?,?,?)";
    private final String ORDER_BY_USER_ID = "select * from project.order s where s.user_id=?";

    private final String ORDER_BY_USER_Status = "select * from project.order s where s.user_id=? and status=?";

    private final String DELITE = "delete from project.order where id=?";
    private final String CHANGE_STATUS = "update project.order set status=? where status=? and user_id=?";

    public OrderRepositoryBD(PostgresqlConnector postgresqlConnector) {
        this.postgresqlConnector = postgresqlConnector;
    }

    public int orderCount(int userId) {
        int count = 0;
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) AS count from project.order s where s.user_id=? and status='FORMED'");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return count;
            }
            resultSet.next();
            String userid1 = resultSet.getString(1);
            count=Integer.valueOf(userid1);
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }



    public List<Order> findOrderByIdAndStatus(int userid, Status status) {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement(ORDER_BY_USER_Status);
            preparedStatement.setInt(1, userid);
            preparedStatement.setString(2, status.name());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return orderList;
            }
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String goodId = resultSet.getString(3);
                String count = resultSet.getString(4);
                String price = resultSet.getString(5);
                Order order = new Order(Integer.valueOf(id), Integer.valueOf(userid), Integer.valueOf(goodId),
                        Double.valueOf(count), Double.valueOf(price), status);
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void addOrder(Order order) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            var maxid = resultSet.getInt(1);
            PreparedStatement preparedStatement1 = connection.prepareStatement(Add_Person);
            preparedStatement1.setInt(1, ++maxid);
            preparedStatement1.setInt(2, order.getUserId());
            preparedStatement1.setInt(3, order.getGoodid());
            preparedStatement1.setDouble(4, order.getCount());
            preparedStatement1.setDouble(5, order.getCost());
            preparedStatement1.setString(6, String.valueOf(order.getStatus()));
            preparedStatement1.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addREOrder(Order order) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement1 = connection.prepareStatement(Add_Person);
            preparedStatement1.setInt(1, order.getId());
            preparedStatement1.setInt(2, order.getUserId());
            preparedStatement1.setInt(3, order.getGoodid());
            preparedStatement1.setDouble(4, order.getCount());
            preparedStatement1.setDouble(5, order.getCost());
            preparedStatement1.setString(6, String.valueOf(order.getStatus()));
            preparedStatement1.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void changeOrder(int userid, String oldStatus, String newStatus) {
        Connection connection = postgresqlConnector.getConnector();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_STATUS);
            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, oldStatus);
            preparedStatement.setInt(3, userid);
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

    @Override
    public void deleteOrder(Order order) {
        Connection connection = postgresqlConnector.getConnector();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELITE);
            preparedStatement.setInt(1, order.getId());
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

    @Override
    public void deleteOrderByStatys(int userid, Status oldstatus) {

    }


    @Override
    public Order findOrderById(int id) {
        try {
            Connection connection = postgresqlConnector.getConnector();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from project.order s where s.id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return new Order();
            }
            resultSet.next();
            String userId = resultSet.getString(2);
            String goodId = resultSet.getString(3);
            String count = resultSet.getString(4);
            String price = resultSet.getString(5);
            String status = resultSet.getString(6);
            if (status.equals("UNFORMED")) {
                Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                        Double.valueOf(count), Double.valueOf(price), Status.UNFORMED);
                return order;
            } else if (status.equals("FORMED")) {
                Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                        Double.valueOf(count), Double.valueOf(price), Status.FORMED);
                return order;
            } else if (status.equals("ON_THE_WAY")) {
                Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                        Double.valueOf(count), Double.valueOf(price), Status.ON_THE_WAY);
                return order;
            } else {
                Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                        Double.valueOf(count), Double.valueOf(price), Status.DELIVERED);
                return order;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = postgresqlConnector.getConnector();
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from project.order");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String goodId = resultSet.getString(3);
                String count = resultSet.getString(4);
                String price = resultSet.getString(5);
                String status = resultSet.getString(6);
                if (status.equals("UNFORMED")) {
                    Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                            Double.valueOf(count), Double.valueOf(price), Status.UNFORMED);
                    orderList.add(order);
                } else if (status.equals("FORMED")) {
                    Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                            Double.valueOf(count), Double.valueOf(price), Status.FORMED);
                    orderList.add(order);
                } else if (status.equals("ON_THE_WAY")) {
                    Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                            Double.valueOf(count), Double.valueOf(price), Status.ON_THE_WAY);
                    orderList.add(order);
                } else if (status.equals("DELIVERED")) {
                    Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(goodId),
                            Double.valueOf(count), Double.valueOf(price), Status.DELIVERED);
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());

        }
        return orderList;
    }
}
