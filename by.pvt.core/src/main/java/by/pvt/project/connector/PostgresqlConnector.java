package by.pvt.project.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnector {

    public Connection  getConnector(){
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/project";
            String username="postgres";
            String password= "sa";
            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
