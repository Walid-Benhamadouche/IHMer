import IHM.*;
import IHM.Label;
import IHM.TextField;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IHMer {
    //declaration
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private Form ihmWin = new Form(screenSize.width, screenSize.height, "IHMer");

    private Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);
    private Color topBar = new Color(238, 186, 43);

    private Label logoL = new Label();
    private Label sideMenuL = new Label();
    private Label homeL = new Label();
    private Label questionsL = new Label();
    private Label profileL = new Label();

    private MyPanel loadingScreen = new MyPanel(Dracula);
    private MyPanel topMenuBar = new MyPanel(screenSize.width, 50, topBar);

    private TextField searchBar = new TextField(240, 30, backColor, Color.gray);

    private Image logInIcon;
    private ImageIcon logo;
    private ImageIcon sideMenu;
    private ImageIcon homeI;
    private ImageIcon questions;
    private ImageIcon profile;


    public IHMer(ResultSet rs) throws SQLException, ClassNotFoundException {
        Home home = new Home(rs);
        try {
            logInIcon = ImageIO.read(new File("IHMerMini.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ihmWin.setIconImage(logInIcon);
        ihmWin.setLayout(new BorderLayout());
        //to test profile passage
        System.out.print(rs.getString("email")+" "+rs.getString("password"));

        //images
        logo = new ImageIcon("IHMer.png");
        logoL.setIcon(logo);
        sideMenu = new ImageIcon("IHMerMini.png");
        sideMenuL.setIcon(sideMenu);
        homeI = new ImageIcon("IHMerMini.png");
        homeL.setIcon(homeI);
        questions = new ImageIcon("IHMerMini.png");
        questionsL.setIcon(questions);
        profile = new ImageIcon("IHMerMini.png");
        profileL.setIcon(profile);

        //loading screen panel show
        //details
        //TODO
        loadingScreen.add(logoL);
        ihmWin.getContentPane().add(loadingScreen, BorderLayout.CENTER);

        topMenuBar.setLayout(new GridBagLayout());
        GridBagConstraints topGbc = new GridBagConstraints();
        topGbc.gridy = 0;
        topGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        topGbc.weightx = -9;
        //top window label
        //side menu
        topGbc.gridx = 0;
        topMenuBar.add(sideMenuL, topGbc);
        //home
        topGbc.gridx = 1;
        topMenuBar.add(homeL, topGbc);
        //Question
        topGbc.gridx = 2;
        topMenuBar.add(questionsL, topGbc);
        //search bar
        topGbc.anchor = GridBagConstraints.FIRST_LINE_END;
        topGbc.weightx = 20;
        topGbc.gridx = 3;
        topMenuBar.add(profileL, topGbc);
        //profile
        topGbc.gridx = 4;
        topMenuBar.add(profileL, topGbc);


        //setting up panels after loading
        ihmWin.getContentPane().add(topMenuBar, BorderLayout.NORTH);
        ihmWin.getContentPane().add(home, BorderLayout.CENTER);

        //setting window visibility to true
        ihmWin.setVisible(true);
    }

    /*public static void main(String[] args) {
        IHMer win = new IHMer();
    }*/
}
