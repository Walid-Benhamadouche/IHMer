package IHM;

import java.sql.*;


public class dbConnection {

    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihmer?autoReconnect=true&useSSL=false","root","");
            return con;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }

}
