package IHM;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SeeAll extends MyPanel
{
    SeeAll(String table) throws SQLException, ClassNotFoundException
    {
        this.setLayout(new GridLayout(0,5,1,1));
        String queryL = "select * from "+table;
        Connection con = dbConnection.getConnection() ;
        PreparedStatement psl = con.prepareStatement(queryL);
        ResultSet rsl = psl.executeQuery();
        while(rsl.next())
        {
            this.add(new dataField(rsl,"lesson"));
        }
    }
}
