import IHM.Form;
import IHM.MyPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Contats {
    private Form contacts = new Form(500, 400, "Contacts");

    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);
    private Color backColor = new Color(230, 145, 56);
    private IHM.Label logoL = new IHM.Label();
    private IHM.Label titleText = new IHM.Label("Californian FB", Font.PLAIN, 21, Orange, "IHMer Blog");
   // private IHM.Label teachersTitle = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Malek Benzerga");

    private ImageIcon logo;
    private Image logInIcon;
    //private IHM.Label userL = new IHM.Label();
   // private ImageIcon userIcon = new ImageIcon("user.png");
    private IHM.Label menad = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Menad Nadia");
    private IHM.Label menadeMail = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "menadNadia@gmail.com");
    private IHM.Label benallal = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Benallal Anis");
    private IHM.Label benallalmail = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "anisBenalla@gmail.com");
    private IHM.Label nait = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Nait Sarah");
    private IHM.Label naitMail = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "naitSarah@gmail.com");

    private IHM.Label mailL = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Mails");
    private IHM.Label userNameLabel = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Teachers Name");
    private MyPanel topPanel = new MyPanel(300, 300, Dracula);

    private MyPanel tablePanel = new MyPanel(Dracula);
    public Contats(){
        contacts.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            logInIcon = ImageIO.read(new File("IHMerMini.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logo = new ImageIcon("IHMer.png");
        logoL.setIcon(logo);

        contacts.setIconImage(logInIcon);

        tablePanel.setLayout(new GridLayout(4,2));
        tablePanel.add(userNameLabel);
        tablePanel.add(mailL);


        tablePanel.add(menad);
        tablePanel.add(menadeMail);

        tablePanel.add(benallal);
        tablePanel.add(benallalmail);


        tablePanel.add(nait);
        tablePanel.add(naitMail);

        mailL.setBorder(new BevelBorder(BevelBorder.RAISED));
        userNameLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        menad.setBorder(new BevelBorder(BevelBorder.LOWERED));
        menadeMail.setBorder(new BevelBorder(BevelBorder.LOWERED));
        benallal.setBorder(new BevelBorder(BevelBorder.LOWERED));
        benallalmail.setBorder(new BevelBorder(BevelBorder.LOWERED));
        nait.setBorder(new BevelBorder(BevelBorder.LOWERED));
        naitMail.setBorder(new BevelBorder(BevelBorder.LOWERED));


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
        topPanel.add(tablePanel, tgbc);

        contacts.getContentPane().add(topPanel);
        //contacts.getContentPane().add(tablePanel, BorderLayout.CENTER);
        contacts.setResizable(false);
contacts.setVisible(true);
    }
    /*public static void main(String[] args) {
        Contats contacts = new Contats();
    }


     */

}
