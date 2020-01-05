package IHM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class ShowQuestion extends MyPanel
{
    public ShowQuestion(ResultSet rs, ResultSet rsu) throws SQLException, ClassNotFoundException {
        Color Dracula = new Color(45, 52, 54);
        Color backColor = new Color(230, 145, 56);

        this.setForeground(backColor);

        this.setLayout(new GridLayout(0,1));
        MyPanel answer = new MyPanel();
        TextArea postTF = new TextArea(1200, 50, new Color(255, 229, 153), new Color(49, 53, 57));

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
        int idq = rs.getInt("idq");
        System.out.print(idq);
        psl.setInt(1,idq);
        ResultSet rsl = psl.executeQuery();
        rsl.last();
        rsl.next();
        while(rsl.previous())
        {
            test.add(new Label("Tahoma", Font.PLAIN, 14, backColor, rsl.getString("respons")));
        }
        JPanel cTest = new JPanel(new BorderLayout());
        cTest.add(test);
        JScrollPane jp = new JScrollPane(cTest);
        this.add(jp);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Button addA = new Button(100, 50, backColor, Dracula, "answer");
        answer.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 0;
        gb.gridy = 0;
        answer.add(postTF);
        gb.gridx = 1;
        answer.add(addA);
        this.add(answer);
        addA.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    addAMouseClicked(idq,postTF,rsu);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void addAMouseClicked(int idq, TextArea text, ResultSet rsu) throws SQLException, ClassNotFoundException {
        String queryI = "insert into respons (idus, idq, respons)"+"VALUES (?,?,?)";

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(queryI, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1,rsu.getInt("idus"));
        ps.setInt(2,idq);
        ps.setString(3,text.getText());
        ps.execute();
        text.setText("");
    }
}
