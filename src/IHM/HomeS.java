package IHM;
import java.awt.*;
import java.sql.*;

public class HomeS extends MyPanel
{
    //declarations
    private Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);

    private Label lessonsL = new Label("Tahoma", Font.PLAIN, 14, backColor, "Lessons");
    private Label lessonsSeeAll = new Label("Tahoma", Font.PLAIN, 14, backColor, "See All");
    private Label importantL = new Label("Tahoma", Font.PLAIN, 14, backColor, "Important");
    private Label importantSeeAll = new Label("Tahoma", Font.PLAIN, 14, backColor, "See All");
    private Label videosL = new Label("Tahoma", Font.PLAIN, 14, backColor, "Videos");
    private Label videosSeeAll = new Label("Tahoma", Font.PLAIN, 14, backColor, "See All");

    private MyPanel lessonsP = new MyPanel(Dracula);
    private MyPanel lessonsPC = new MyPanel(Color.gray);
    private MyPanel importantP = new MyPanel(Dracula);
    private MyPanel importantPC = new MyPanel(Color.gray);
    private MyPanel videosP = new MyPanel(Dracula);
    private MyPanel videosPC = new MyPanel(Color.gray);
    private MyPanel quoteP = new MyPanel(Dracula);
    private MyPanel postP = new MyPanel(Color.red);
    private MyPanel empty1 = new MyPanel(Color.GREEN);
    private MyPanel empty2 = new MyPanel(Color.GREEN);
    private MyPanel empty3 = new MyPanel(Color.GREEN);
    private MyPanel empty4 = new MyPanel(Color.GREEN);
    private MyPanel empty5 = new MyPanel(Color.GREEN);
    private MyPanel empty6 = new MyPanel(Color.GREEN);

    //jTextPane
    private TextField postTF = new TextField(400, 100, new Color(255, 229, 153), new Color(49, 53, 57));

    private Button postB = new Button(80, 30, backColor, Dracula, "Post question");

    public HomeS() throws SQLException, ClassNotFoundException {
        //postP

        //lessonPC
        lessonsPC.setLayout(new GridLayout());
        String queryL = "select * from lesson";
        Connection con = dbConnection.getConnection() ;
        PreparedStatement psl = con.prepareStatement(queryL);
        ResultSet rsl = psl.executeQuery();
        for(int i=0; rsl.next() && i<4; i++)
        {
            lessonsPC.add(new dataField(rsl));
        }

        //newsPC
        importantPC.setLayout(new GridLayout());
        String queryN = "select * from news";
        PreparedStatement psn = con.prepareStatement(queryN);
        ResultSet rsn = psn.executeQuery();
        for(int i=0; rsn.next() && i<4; i++)
        {
            importantPC.add(new dataField(rsn));
        }

        //videoPC
        videosPC.setLayout(new GridLayout());
        String queryV = "select * from news";
        PreparedStatement psv = con.prepareStatement(queryV);
        ResultSet rsv = psv.executeQuery();
        for(int i=0; rsv.next() && i<4; i++)
        {
            importantPC.add(new dataField(rsv));
        }

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
        lessGBC.gridy=0;
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
        impGBC.gridy=0;
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
        vidGBC.gridy=0;
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
        this.add(quoteP);

    }

}
