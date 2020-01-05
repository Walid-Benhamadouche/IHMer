package IHM;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class HomeS extends MyPanel
{
    //declarations
    private Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);

    private Label lessonsL = new Label("Comic Sans MS", Font.PLAIN, 20, backColor, "Lessons");
    private Label lessonsSeeAll = new Label("Comic Sans MS", Font.PLAIN, 14, backColor, "See All           ");
    private Label importantL = new Label("Comic Sans MS", Font.PLAIN, 20, backColor, "Important");
    private Label importantSeeAll = new Label("Comic Sans MS", Font.PLAIN, 14, backColor, "See All           ");
    private Label videosL = new Label("Comic Sans MS", Font.PLAIN, 20, backColor, "Videos");
    private Label videosSeeAll = new Label("Comic Sans MS", Font.PLAIN, 14, backColor, "See All           ");

    private MyPanel lessonsP = new MyPanel(Dracula);
    private MyPanel lessonsPC = new MyPanel(Dracula);
    private MyPanel importantP = new MyPanel(Dracula);
    private MyPanel importantPC = new MyPanel(Dracula);
    private MyPanel videosP = new MyPanel(Dracula);
    private MyPanel videosPC = new MyPanel(Dracula);
   // private MyPanel quoteP = new MyPanel(Dracula);
    private MyPanel postP = new MyPanel(Dracula);
    private MyPanel empty1 = new MyPanel(Dracula);
    private MyPanel empty2 = new MyPanel(Dracula);
    private MyPanel empty3 = new MyPanel(Dracula);
    private MyPanel empty4 = new MyPanel(Dracula);
    private MyPanel empty5 = new MyPanel(Dracula);
    private MyPanel empty6 = new MyPanel(Dracula);

    private TextArea postTF = new TextArea(700, 100, new Color(255, 229, 153), new Color(49, 53, 57));

    private Button postB = new Button(120, 30, backColor, Dracula, "Post question");

    public HomeS(ResultSet rsu) throws SQLException, ClassNotFoundException {

        //postP
        postP.add(postTF);
        postP.add(postB);

        //lessonPC
        lessonsPC.setLayout(new GridLayout());
        String queryL = "select * from lesson";
        Connection con = dbConnection.getConnection() ;
        PreparedStatement psl = con.prepareStatement(queryL);
        ResultSet rsl = psl.executeQuery();
        rsl.last();
        rsl.next();
        for(int i=0; rsl.previous() && i<8; i++)
        {
            lessonsPC.add(new dataField(rsl,"lesson"));
        }

        //newsPC
        importantPC.setLayout(new GridLayout());
        String queryN = "select * from news";
        PreparedStatement psn = con.prepareStatement(queryN);
        ResultSet rsn = psn.executeQuery();
        rsn.last();
        rsn.next();
        for(int i=0; rsn.previous() && i<8; i++)
        {
            importantPC.add(new dataField(rsn,"news"));
        }

        //videoPC
        videosPC.setLayout(new GridLayout());
        String queryV = "select * from video";
        PreparedStatement psv = con.prepareStatement(queryV);
        ResultSet rsv = psv.executeQuery();
        rsv.last();
        rsv.next();
        for(int i=0; rsv.previous() && i<8; i++)
        {
            videosPC.add(new dataField(rsv,"video"));
        }

        lessonsPC.setBorder(new LineBorder(Color.gray));
        importantPC.setBorder(new LineBorder(Color.gray));
        videosPC.setBorder(new LineBorder(Color.gray));

        //lessonsP
        empty1.setPreferredSize(new Dimension(10,20));
        empty2.setPreferredSize(new Dimension(10,20));
        //init
        lessonsP.setLayout(new GridBagLayout());
        GridBagConstraints lessGBC = new GridBagConstraints();
        lessGBC.weightx = 1;
        lessGBC.fill = GridBagConstraints.NONE;
        lessGBC.gridx = 0;
        lessGBC.gridy = 0;
        lessGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        //empty space
        lessonsP.add(empty1, lessGBC);
        //adding lessons label

        lessGBC.gridx = 1;

        lessonsP.add(lessonsL, lessGBC);
        //adding see all label
        lessGBC.weightx = 1;
        lessGBC.gridy = 1;
        lessonsP.add(lessonsSeeAll, lessGBC);

        //adding squares field
        lessGBC.gridx=2;
        lessGBC.gridy=1;
        lessonsP.add(lessonsPC, lessGBC);
        lessGBC.weightx = 200;
        lessGBC.gridx=3;
        lessonsP.add(empty2, lessGBC);

        //importantP
        empty3.setPreferredSize(new Dimension(10,20));
        empty4.setPreferredSize(new Dimension(10,20));
        //init
        importantP.setLayout(new GridBagLayout());
        GridBagConstraints impGBC = new GridBagConstraints();
        impGBC.weightx = 1;
        impGBC.fill = GridBagConstraints.NONE;
        impGBC.gridx = 0;
        impGBC.gridy = 0;
        impGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        //empty space
        importantP.add(empty3, impGBC);
        //adding important label

        impGBC.gridx = 1;

        importantP.add(importantL, impGBC);
        //adding see all label
        impGBC.weightx = 1;
        impGBC.gridy = 1;
        importantP.add(importantSeeAll, impGBC);

        //adding squares field
        impGBC.gridx=2;
        impGBC.gridy=1;
        importantP.add(importantPC, impGBC);
        impGBC.weightx = 200;
        impGBC.gridx=3;
        importantP.add(empty4, impGBC);

        //videosP
        empty5.setPreferredSize(new Dimension(10,20));
        empty6.setPreferredSize(new Dimension(10,20));
        //init
        videosP.setLayout(new GridBagLayout());
        GridBagConstraints vidGBC = new GridBagConstraints();
        vidGBC.weightx = 1;
        vidGBC.fill = GridBagConstraints.NONE;
        vidGBC.gridx = 0;
        vidGBC.gridy = 0;
        vidGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        //empty space
        videosP.add(empty5, vidGBC);
        //adding important label

        vidGBC.gridx = 1;

        videosP.add(videosL, vidGBC);
        //adding see all label
        vidGBC.weightx = 1;
        vidGBC.gridy = 1;
        videosP.add(videosSeeAll, vidGBC);

        //adding squares field
        vidGBC.gridx=2;
        vidGBC.gridy=1;
        videosP.add(videosPC, vidGBC);
        vidGBC.weightx = 200;
        vidGBC.gridx=3;
        videosP.add(empty6, vidGBC);

        //quoteP


        this.setLayout(new GridLayout(0,1));
        this.add(postP);
        this.add(lessonsP);
        this.add(importantP);
        this.add(videosP);
        //this.add(quoteP);

        postB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    postBMouseListener(rsu);
                } catch (SQLException | ClassNotFoundException ex) {
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

        lessonsSeeAll.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    lessonsSeeAllMouseClicked();
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

        importantSeeAll.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    importantSeeAllMouseClicked();
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

        videosSeeAll.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    videosSeeAllMouseClicked();
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

    private void postBMouseListener(ResultSet rsu) throws SQLException, ClassNotFoundException {
        String queryS = "SELECT ids FROM student WHERE idus = ?";
        String queryI = "insert into question (ids, question)"+"VALUES (?,?)";

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(queryS, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, rsu.getInt("idus"));

        ResultSet rsS= ps.executeQuery();
        rsS.next();

        PreparedStatement ps1 = con.prepareStatement(queryI);

        ps1.setInt(1, rsS.getInt("ids"));
        ps1.setString(2, postTF.getText());
        ps1.execute();
        postTF.setText("");
    }

    private void videosSeeAllMouseClicked() throws SQLException, ClassNotFoundException {
        this.removeAll();
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(0,4));
        test.setBackground(Dracula);
        String queryL = "select * from video";
        Connection con = dbConnection.getConnection() ;
        PreparedStatement psl = con.prepareStatement(queryL);
        ResultSet rsl = psl.executeQuery();
        rsl.last();
        rsl.next();
        while(rsl.previous())
        {
            test.add(new dataField(rsl,"video"));
        }
        JPanel cTest = new JPanel(new BorderLayout());
        cTest.add(test);
        JScrollPane jp = new JScrollPane(cTest);
        this.add(jp);
        this.repaint();
    }

    private void importantSeeAllMouseClicked() throws SQLException, ClassNotFoundException {
        this.removeAll();
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(0,4));
        test.setBackground(Dracula);
        String queryL = "select * from news";
        Connection con = dbConnection.getConnection() ;
        PreparedStatement psl = con.prepareStatement(queryL);
        ResultSet rsl = psl.executeQuery();
        rsl.last();
        rsl.next();
        while(rsl.previous())
        {
            test.add(new dataField(rsl,"news"));
        }
        JPanel cTest = new JPanel(new BorderLayout());
        cTest.add(test);
        JScrollPane jp = new JScrollPane(cTest);
        this.add(jp);
        this.repaint();
    }

    private void lessonsSeeAllMouseClicked() throws SQLException, ClassNotFoundException {
        this.removeAll();
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(0,4));
        test.setBackground(Dracula);
        String queryL = "select * from lesson";
        Connection con = dbConnection.getConnection() ;
        PreparedStatement psl = con.prepareStatement(queryL);
        ResultSet rsl = psl.executeQuery();
        rsl.last();
        rsl.next();
        while(rsl.previous())
        {
            test.add(new dataField(rsl,"lesson"));
        }
        JPanel cTest = new JPanel(new BorderLayout());
        cTest.add(test);
        JScrollPane jp = new JScrollPane(cTest);
        this.add(jp);
        this.repaint();
    }

    public void reShow()
    {
        this.removeAll();
        this.add(postP);
        this.add(lessonsP);
        this.add(importantP);
        this.add(videosP);
        //this.add(quoteP);
        this.repaint();
    }

}
