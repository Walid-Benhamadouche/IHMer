package IHM;

import java.sql.*;


public class dbConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ihmer?autoReconnect=true&useSSL=false","root","dragonhead1234");
    }

}
