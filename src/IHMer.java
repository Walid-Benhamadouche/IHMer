import IHM.*;
import IHM.Label;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

class IHMer {
    //declaration
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private Form ihmWin = new Form(screenSize.width, screenSize.height, "IHMer");

    private Color Dracula = new Color(45, 52, 54);
    private Color topBar = new Color(238, 186, 43);

    private Label logoL = new Label();
    private Label sideMenuL = new Label();
    private Label homeL = new Label();
    private Label questionsL = new Label();
    private Label profileL = new Label();

    private MyPanel loadingScreen = new MyPanel(Dracula);
    private MyPanel topMenuBar = new MyPanel(screenSize.width, 50, topBar);

    private Image logInIcon;
    private ImageIcon logo;
    private ImageIcon sideMenu;
    private ImageIcon homeI;
    private ImageIcon questions;
    private ImageIcon profile;

    private boolean test;

    IHMer(ResultSet rs) throws SQLException, ClassNotFoundException {

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
        sideMenu = new ImageIcon("hum.png");
        sideMenuL.setIcon(sideMenu);
        homeI = new ImageIcon("IHMerMini.png");
        homeL.setIcon(homeI);
        questions = new ImageIcon("Qq.png");
        questionsL.setIcon(questions);
        profile = new ImageIcon("user.png");
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
        test = rs.getString("profile").equals("teacher");
        Home homet = new Home(rs);
        HomeS homes = new HomeS(rs);
        if(test)
        {
            ihmWin.getContentPane().add(homet, BorderLayout.CENTER);
        }
        else
        {

            ihmWin.getContentPane().add(homes, BorderLayout.CENTER);
        }

        //setting window visibility to true
        ihmWin.setVisible(true);

        homeL.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homeLMouseClicked(homet, homes);
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

    private void homeLMouseClicked(Home homet,HomeS homes)
    {
        if (test)
            homet.reShow();
        else
            homes.reShow();
    }

}