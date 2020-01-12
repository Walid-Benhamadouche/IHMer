import IHM.*;
import IHM.TextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class QuestionPanel extends MyPanel {

    //declaration
//    private Form wnd = new Form(800, 600, "Question");
    private static Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);
    private MyPanel bigPanel = new MyPanel(Dracula);


    //ta3 qst + post
    private MyPanel postQstPanel = new MyPanel(Dracula);
    private IHM.TextArea qstPoseLabel = new TextArea(700, 100, new Color(255, 229, 153), new Color(49, 53, 57));
    private JButton postButton = new JButton();
    private ArrayList<Question> questions;


    public QuestionPanel(ResultSet rsu) throws SQLException, ClassNotFoundException {
        super(Dracula);
        this.questions = loadQuestions(rsu);
        this.setLayout(new FlowLayout());

        postButton.setText("Post question");
        postButton.setSize(200, 40);
        postButton.setBackground(backColor);
        postButton.setForeground(Dracula);
        postButton.setFont(new Font("Californian FB", Font.BOLD, 18));
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    postBMouseListener(rsu);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //postQstPanel
        postQstPanel.add(qstPoseLabel);
        postQstPanel.add(postButton);
        bigPanel.setLayout(new GridLayout(this.questions.size() + 1, 1, 0, 10));
        bigPanel.add(postQstPanel, BorderLayout.NORTH);
        System.out.println("Showing " + this.questions.size() + " questions");
        for (Question qs : this.questions) {
            bigPanel.add(new SinglQstPan(qs), BorderLayout.CENTER);
            //replyBtn.setText("Show Replies: "+q.getRepliesCnter()+ " Replies");
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(bigPanel);
        this.add(bigPanel);
        this.revalidate();
        this.repaint();

    }

    private void postBMouseListener(ResultSet rsu) throws SQLException, ClassNotFoundException {
        String queryS = "SELECT ids FROM student WHERE idus = ?";
        String queryI = "insert into question (ids, question)" + "VALUES (?,?)";

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(queryS, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, rsu.getInt("idus"));

        ResultSet rsS = ps.executeQuery();
        rsS.next();

        PreparedStatement ps1 = con.prepareStatement(queryI);

        ps1.setInt(1, rsS.getInt("ids"));
        ps1.setString(2, qstPoseLabel.getText());
        ps1.execute();
        qstPoseLabel.setText("");
    }


    public void addAMouseClicked(int idq, TextArea text, ResultSet rsu) throws SQLException, ClassNotFoundException {
        String queryI = "insert into respons (idus, idq, respons)" + "VALUES (?,?,?)";

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(queryI, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, rsu.getInt("idus"));
        ps.setInt(2, idq);
        ps.setString(3, text.getText());
        ps.execute();
        text.setText("");
    }

    private ArrayList<Question> loadQuestions(ResultSet rsu) throws SQLException, ClassNotFoundException {
        ArrayList<Question> questions = new ArrayList<>();


        String queryL = "select * from question";
        Connection con = dbConnection.getConnection();
        PreparedStatement psl = con.prepareStatement(queryL);
        ResultSet rsl = psl.executeQuery();

        rsl.last();
        rsl.next();
        while (rsl.previous()) {

            String query = "select * from user where `idus` = ?";
            String query2 = "select * from student where `ids` = ?";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = con.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
            ps2.setInt(1, rsl.getInt("ids"));
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            ps.setInt(1, (rs2.getInt("idus")));
            ResultSet rs1 = ps.executeQuery();



            while (rs1.next()) {
                String username = rs1.getString("username");
                String questionText = rsl.getString("question");
                System.out.println("username " + username + " question " + questionText);
                Question question = new Question(username, questionText);
                    question.addReplie("Benhamadouch","i really dunno! good luck !!");
                    question.addReplie("Benallal","i thing i ve got the same problem too");
                questions.add(question);
            }
        }

        return questions;
    }

    public static void main(String[] args) {
        Question qes = new Question("Oussama Abderhim", "i hope evryone s doing good ?");
        qes.addReplie("Benmara Sounsous", "goood yea goood brother");
        Question qes1 = new Question("Malek Ben", "kraht wala ghi ana??");
        qes.addReplie("Benmara Sounsous", "goood yea goood brother");
        ArrayList<Question> q = new ArrayList<>();
        q.add(0, qes);
        q.add(1, qes1);
        //QuestionPanel wd = new QuestionPanel();
    }

}
