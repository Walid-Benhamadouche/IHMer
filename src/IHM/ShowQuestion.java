package IHM;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ShowQuestion extends MyPanel
{
    public ShowQuestion(ResultSet rs) throws SQLException, ClassNotFoundException {
        Color Dracula = new Color(45, 52, 54);
        Color backColor = new Color(230, 145, 56);

        this.setForeground(backColor);

        this.setLayout(new GridLayout(0,1));
        MyPanel answer = new MyPanel();
        TextArea postTF = new TextArea(700, 100, new Color(255, 229, 153), new Color(49, 53, 57));

        String query = "select * from user where `idus` = ?";
        String query2 = "select * from student where `ids` = ?";
        Connection con = dbConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement ps2 = con.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
        ps2.setInt(1,rs.getInt("ids"));
        ResultSet rs2 = ps2.executeQuery();
        rs2.next();
        ps.setInt(1, rs.getInt(rs2.getInt("idus")));
        ResultSet rs1 = ps.executeQuery();

        rs1.next();

        String wth = "<html>question by "+rs1.getString("username")+"<br>"+rs.getString("question")+"</html>";

        Label question = new Label("Tahoma", Font.PLAIN, 14, backColor,wth/*"             hi     "+rs1.getString("username")+"\n"+rs.getString("question")*/);
        this.add(question);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(0,1));
        test.setBackground(Dracula);
        String queryL = "select * from respons where `idq` = ?";
        PreparedStatement psl = con.prepareStatement(queryL);
        psl.setInt(1,rs.getInt("idq"));
        ResultSet rsl = psl.executeQuery();
        rsl.last();
        rsl.next();
        while(rsl.previous())
        {
            System.out.print(String.valueOf(rsl.getString("respons")));
            test.add(new Label("Tahoma", Font.PLAIN, 14, backColor, rsl.getString("respons")+"hi"));
        }
        JPanel cTest = new JPanel(new BorderLayout());
        cTest.add(test);
        JScrollPane jp = new JScrollPane(cTest);
        this.add(jp);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        answer.setLayout(new GridLayout(1,2));
        answer.add(postTF);
        answer.add(new Button(120, 30, backColor, Dracula, "answer"));
        this.add(answer);

    }
}
