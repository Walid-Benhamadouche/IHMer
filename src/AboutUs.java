import IHM.Form;
import IHM.Label;
import IHM.MyPanel;
import IHM.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.white;

public class AboutUs {
    //declarations
        private Form aboutUs = new Form(500, 400, "About Us");
    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);
    private IHM.Label logoL = new IHM.Label();
    private IHM.Label titleText = new IHM.Label("Comic Sans MS", Font.PLAIN, 21, Orange, "IHMer Blog");
    private IHM.Label texte = new Label("Comic Sans MS", Font.PLAIN, 17, white,"");
    private MyPanel topPanel = new MyPanel(300, 300, Dracula);
    private MyPanel downPanel = new MyPanel(200, 100, Dracula);
    private ImageIcon logo;
    private Image logInIcon;


    public AboutUs() {
        try {
            logInIcon = ImageIO.read(new File("IHMerMini.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        texte.setText("<html><pre> IHMer Blog for students and Teachers<br/> The place where you are an IHM expert!<br/> \tVersion: 1.0.0 - 25/11/2019 09:30<br/> \tDeveloped by:<br/> Benhamadouch Walid and  Benzerga Malek Kheira<br/><br/> \t(c) 2019-2020 </pre></html>");
        //topPanel Configuration
        logo = new ImageIcon("IHMer.png");
        logoL.setIcon(logo);
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints tgbc = new GridBagConstraints();
        tgbc.weighty = 100;
        tgbc.fill = GridBagConstraints.NONE;
        tgbc.gridx = 0;
        //logoL-------------------------
        tgbc.gridy = 0;
        tgbc.weighty = 10;
        topPanel.add(logoL, tgbc);
        tgbc.weighty = 10;
        tgbc.gridy = 1;
        topPanel.add(titleText, tgbc);
        tgbc.weighty = 10;
        tgbc.gridy = 2;
        topPanel.add(texte, tgbc);



        logo = new ImageIcon("IHMer.png");
        logoL.setIcon(logo);
        aboutUs.setIconImage(logInIcon);


        aboutUs.setIconImage(logInIcon);
        aboutUs.setLayout(new BorderLayout());

        logo = new ImageIcon("IHMer.png");
        logoL.setIcon(logo);
        aboutUs.setIconImage(logInIcon);
        aboutUs.getContentPane().add(topPanel, BorderLayout.NORTH);
        aboutUs.getContentPane().add(downPanel, BorderLayout.SOUTH);
        aboutUs.setResizable(false);
        aboutUs.setVisible(true);
    }
    public static void main(String[] args) {
        AboutUs aboutUs = new AboutUs();
    }
}

