import IHM.*;
import IHM.*;
import IHM.Button;
import IHM.Label;
import IHM.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class SignUp {
    //declarations
    private Form signUp = new Form(1000, 700, "Sign Up");

    private Image logInIcon;
    private ImageIcon logo;

    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);

    private Label joinUsText = new Label("Times New Roman", Font.PLAIN, 25, Orange, "   Join us");
    private Label logoL = new Label();
    private Label E_mailL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "E-mail");
    private Label PasswordL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Password");

    private Label userNameL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "User Name");
    private Label confirmL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Confirm");

    private Separator E_mailS = new Separator(240, Color.gray);
    private Separator PasswordS = new Separator(240, Color.gray);

    private Separator userNameS = new Separator(240, Color.gray);
    private Separator confirmS = new Separator(240, Color.gray);

    private TextField E_mailF = new TextField(240, 30, Dracula, Color.gray);
    private PasswordField PasswordF = new PasswordField(240, 30, Dracula, Color.gray);

    private TextField userNameF = new TextField(240, 30, Dracula, Color.gray);
    private PasswordField confirmF = new PasswordField(240, 30, Dracula, Color.gray);

    private MyPanel topPanel = new MyPanel(1000, 80, Dracula);
    private MyPanel mainPanel = new MyPanel(1000, 620, Dracula);


    public SignUp() {
        try {
            logInIcon = ImageIO.read(new File("IHMerMini.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        signUp.setIconImage(logInIcon);

        signUp.setLayout(new BorderLayout());

        //topPanel Configuration

        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints tgbc = new GridBagConstraints();

        tgbc.gridx = 0;
        //logoL-------------------------
        tgbc.gridy = 0;
        topPanel.add(logoL, tgbc);
        //Join Us text----------------------
        tgbc.gridy = 1;
        topPanel.add(joinUsText, tgbc);
        //mainPanel configuration
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints mainGbc = new GridBagConstraints();

        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        mainGbc.anchor = GridBagConstraints.FIRST_LINE_END;
        mainGbc.fill = GridBagConstraints.NONE;
        mainGbc.weighty = 0.5;

        //Username label-field-------
        mainPanel.add(userNameL, mainGbc);
        //userName Field-------------

        mainGbc.gridx = 1;
        mainPanel.add(userNameF, mainGbc);
        //Username separator---------
        mainGbc.gridy = 1;
        mainPanel.add(userNameS, mainGbc);
        //E_mail label-field---------
        mainGbc.gridx = 0;
        mainGbc.gridy = 2;
        mainPanel.add(E_mailL, mainGbc);
        //E_mail field---------------
        mainGbc.gridx = 1;
        mainPanel.add(E_mailF, mainGbc);
        //E_mail separator-----------
        mainGbc.gridy = 3;
        mainPanel.add(E_mailS, mainGbc);
        //Password label-field-------
        mainGbc.gridx = 0;
        mainGbc.gridy = 4;
        mainPanel.add(PasswordL, mainGbc);
        //Password Field-------------
        mainGbc.gridx = 1;
        mainPanel.add(PasswordF, mainGbc);
        //Password separator---------
        mainGbc.gridy = 5;
        mainPanel.add(PasswordS, mainGbc);
        //Confirm password label-field
        mainGbc.gridy = 6;
        mainGbc.gridx = 0;
        mainPanel.add(confirmL, mainGbc);
        //Confirm password field-----
        mainGbc.gridx = 1;
        mainPanel.add(confirmF, mainGbc);
        //Confirm password separator-
        mainGbc.gridy = 7;
        mainPanel.add(confirmS, mainGbc);
        logo = new ImageIcon("IHMer.png");

        signUp.getContentPane().add(mainPanel, BorderLayout.CENTER);
        signUp.getContentPane().add(topPanel, BorderLayout.NORTH);
        logoL.setIcon(logo);
        signUp.setVisible(true);


    }

    public static void main(String[] args) {
        SignUp signup = new SignUp();
    }


}
