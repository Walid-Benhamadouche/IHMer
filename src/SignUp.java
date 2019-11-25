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
    private Form signUp = new Form(700, 440, "Sign Up");

    private Image logInIcon;
    private ImageIcon logo;

    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);

    private Label joinUsText = new Label("Times New Roman", Font.PLAIN, 25, Orange, "   Join us");
    private Label logoL = new Label();
    private Label E_mailL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "E-mail   ");
    private Label PasswordL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Password   ");
    private Label userNameL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "User Name   ");
    private Label confirmL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Confirm   ");
    private Label userProfileL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "User Profile   ");
    private Label alreadyMember = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Already a member ?");

    private Separator E_mailS = new Separator(240, Color.gray);
    private Separator PasswordS = new Separator(240, Color.gray);

    private Separator userNameS = new Separator(240, Color.gray);
    private Separator confirmS = new Separator(240, Color.gray);

    private CheckBox student = new CheckBox(Dracula, Color.gray, "Student");
    private CheckBox teacher = new CheckBox(Dracula, Color.gray, "Teacher");

    private TextField E_mailF = new TextField(240, 30, Dracula, Color.gray);
    private PasswordField PasswordF = new PasswordField(240, 30, Dracula, Color.gray);

    private TextField userNameF = new TextField(240, 30, Dracula, Color.gray);
    private PasswordField confirmF = new PasswordField(240, 30, Dracula, Color.gray);

    private MyPanel topPanel = new MyPanel(700, 100, Dracula);
    private MyPanel mainPanel = new MyPanel(700, 310, Dracula);
    private MyPanel botPanel =new MyPanel(700, 50, Dracula);

    private Button cancel = new Button(80, 30, Orange, Dracula,"Cancel");
    private Button sign_Up = new Button(85, 30, Orange, Dracula,"Sign Up");
    private Button sign_In = new Button(80, 18, Orange, Dracula,"Sign In");


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
        botPanel.setLayout((new GridBagLayout()));
        GridBagConstraints botGbc = new GridBagConstraints();

        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        mainGbc.anchor = GridBagConstraints.FIRST_LINE_END;
        mainGbc.fill = GridBagConstraints.NONE;
        mainGbc.weighty = 1;

        //Username label-field-------
        mainGbc.weighty = 0.1;
        mainPanel.add(userNameL, mainGbc);
        //userName Field-------------
        mainGbc.gridx = 1;
        mainPanel.add(userNameF, mainGbc);
        //Username separator---------
        mainGbc.weighty = 1;
        mainGbc.gridy = 1;
        mainPanel.add(userNameS, mainGbc);
        //E_mail label-field---------
        mainGbc.weighty = 0.1;
        mainGbc.gridx = 0;
        mainGbc.gridy = 2;
        mainPanel.add(E_mailL, mainGbc);
        //E_mail field---------------
        mainGbc.gridx = 1;
        mainPanel.add(E_mailF, mainGbc);
        //E_mail separator-----------
        mainGbc.weighty = 1;
        mainGbc.gridy = 3;
        mainPanel.add(E_mailS, mainGbc);
        //Password label-field-------
        mainGbc.weighty = 0.1;
        mainGbc.gridx = 0;
        mainGbc.gridy = 4;
        mainPanel.add(PasswordL, mainGbc);
        //Password Field-------------
        mainGbc.gridx = 1;
        mainPanel.add(PasswordF, mainGbc);
        //Password separator---------
        mainGbc.weighty = 1;
        mainGbc.gridy = 5;
        mainPanel.add(PasswordS, mainGbc);
        //Confirm password label-field
        mainGbc.weighty = 0.1;
        mainGbc.gridy = 6;
        mainGbc.gridx = 0;
        mainPanel.add(confirmL, mainGbc);
        //Confirm password field-----
        mainGbc.gridx = 1;
        mainPanel.add(confirmF, mainGbc);
        //Confirm password separator-
        mainGbc.weighty = 1;
        mainGbc.gridy = 7;
        mainPanel.add(confirmS, mainGbc);
        //User ProfileL--------------
        mainGbc.gridy = 8 ;
        mainGbc.gridx = 0;
        mainPanel.add(userProfileL, mainGbc);
        //Student--------------------
        mainGbc.gridx = 1;
        mainGbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(student, mainGbc);
        //Teacher--------------------
        mainGbc.gridx = 2;
        mainPanel.add(teacher, mainGbc);
        //Already a member----------
        botGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        botGbc.gridx = 0;
        botGbc.gridy = 0;
        botPanel.add(alreadyMember, botGbc);
        //sign_In-------------------
        botGbc.gridx = 1;
        botPanel.add(sign_In, botGbc);
       //Cancel button--------------
        botGbc.anchor = GridBagConstraints.FIRST_LINE_END;
        botGbc.gridx = 2;
        botPanel.add(cancel, botGbc);
        //Sign_Up button-------------
        botGbc.gridx = 3;
        botPanel.add(sign_Up, botGbc);

        logo = new ImageIcon("IHMer.png");

        signUp.getContentPane().add(mainPanel, BorderLayout.CENTER);
        signUp.getContentPane().add(topPanel, BorderLayout.NORTH);
        signUp.getContentPane().add(botPanel, BorderLayout.SOUTH);
        logoL.setIcon(logo);
        signUp.setVisible(true);


    }

    public static void main(String[] args) {
        SignUp signup = new SignUp();
    }


}
