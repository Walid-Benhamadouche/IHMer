import IHM.*;
import IHM.Button;
import IHM.Label;
import IHM.TextField;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;

public class SignUp { //i added botPanel for hadok l buttons li lta7t
    //declarations
    private Form signUp = new Form(800, 600, "Sign Up");

    private Image logInIcon;
    private ImageIcon logo;

    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);

    private Label joinUsText = new Label("Californian FB", Font.PLAIN, 25, Orange, "   Join us");
    private Label logoL = new Label();
    private Label E_mailL = new Label("Californian FB", Font.PLAIN, 16, Color.gray, "E-mail   ");
    private Label PasswordL = new Label("Californian FB", Font.PLAIN, 16, Color.gray, "Password   ");
    private Label userNameL = new Label("Californian FB", Font.PLAIN, 16, Color.gray, "User Name   ");
    private Label confirmL = new Label("Californian FB", Font.PLAIN, 16, Color.gray, "Confirm   ");
    private Label userProfileL = new Label("Californian FB", Font.PLAIN, 16, Color.gray, "User Profile   ");
    private Label alreadyMember = new Label("Californian FB", Font.PLAIN, 16, Color.gray, "       Already a member ?");

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

    private MyPanel topPanel = new MyPanel(800, 150, Dracula);
    private MyPanel mainPanel = new MyPanel(800, 200, Dracula);
    private MyPanel botPanel = new MyPanel(800, 60, Dracula);

    private Button cancel = new Button(80, 30, Orange, Dracula, "Cancel");
    private Button sign_Up = new Button(85, 30, Orange, Dracula, "Sign Up");
    private Button sign_In = new Button(80, 18, Orange, Dracula, "Sign In");


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
        //mainGbc.weighty=-1;
        mainPanel.add(confirmF, mainGbc);
        //Confirm password separator-
        mainGbc.weighty = 1;
        mainGbc.gridy = 7;
        mainPanel.add(confirmS, mainGbc);
        //User ProfileL--------------
        mainGbc.gridy = 8;
        mainGbc.gridx = 0;
        mainGbc.weighty = -1;
        mainPanel.add(userProfileL, mainGbc);
        //Student--------------------
        mainGbc.gridx = 1;
        mainGbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(student, mainGbc);
        student.setSelected(true);
        //Teacher--------------------
        mainGbc.gridx = 2;
        mainPanel.add(teacher, mainGbc);
        //Already a member----------
        botGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        botGbc.gridx = 0;
        botGbc.gridy = 0;
        botGbc.weightx = 6;
        botGbc.weighty = -9;
        botPanel.add(alreadyMember, botGbc);
        //sign_In-------------------
        botGbc.gridx = 1;
        botGbc.weightx = 20;
        botPanel.add(sign_In, botGbc);
        //Cancel button--------------
        botGbc.anchor = GridBagConstraints.FIRST_LINE_END;
        botGbc.gridx = 3;
        botPanel.add(cancel, botGbc);
        //Sign_Up button-------------
        botGbc.gridx = 4;
        botPanel.add(sign_Up, botGbc);

        userNameF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                {
                    userNameFFocusGained();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                {
                    userNameFFocusLost();
                }
            }
        });

        E_mailF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                {
                    E_mailFFocusGained();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                {
                    E_mailFFocusLost();
                }
            }
        });

        PasswordF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                {
                    PasswordFFocusGained();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                {
                    PasswordFFocusLost();
                }
            }
        });

        confirmF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                {
                    confirmFFocusGained();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                {
                    confirmFFocusLost();
                }

            }
        });

        student.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                studentFocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                studentFocusLost();
            }
        });

        teacher.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                teacherFocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                teacherFocusLost();
            }
        });

        teacher.addActionListener(e -> teacherActionPerformed());

        student.addActionListener(e -> studentActionPerformed());

        cancel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelMouseExited();
            }
        });
        sign_In.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignInMouseClicked();
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

        sign_Up.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                signUpMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                signUpMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpMouseExited();
            }
        });

        logo = new ImageIcon("IHMer.png");

        signUp.getContentPane().add(mainPanel, BorderLayout.CENTER);
        signUp.getContentPane().add(topPanel, BorderLayout.NORTH);
        signUp.getContentPane().add(botPanel, BorderLayout.SOUTH);
        logoL.setIcon(logo);
        signUp.setVisible(true);


    }

    private void userNameFFocusGained() {
        userNameF.setForeground(Orange);
        userNameL.setForeground(Orange);
        userNameS.setForeground(Orange);
    }

    private void userNameFFocusLost() {
        userNameF.setForeground(Color.gray);
        userNameL.setForeground(Color.gray);
        userNameS.setForeground(Color.gray);
    }

    private void E_mailFFocusGained() {
        E_mailF.setForeground(Orange);
        E_mailL.setForeground(Orange);
        E_mailS.setForeground(Orange);
    }

    private void E_mailFFocusLost() {
        E_mailF.setForeground(Color.gray);
        E_mailL.setForeground(Color.gray);
        E_mailS.setForeground(Color.gray);
    }

    private void PasswordFFocusGained() {
        PasswordF.setForeground(Orange);
        PasswordL.setForeground(Orange);
        PasswordS.setForeground(Orange);
    }

    private void PasswordFFocusLost() {
        PasswordF.setForeground(Color.gray);
        PasswordL.setForeground(Color.gray);
        PasswordS.setForeground(Color.gray);
    }

    private void confirmFFocusGained() {
        confirmF.setForeground(Orange);
        confirmL.setForeground(Orange);
        confirmS.setForeground(Orange);
    }

    private void confirmFFocusLost() {
        confirmF.setForeground(Color.gray);
        confirmL.setForeground(Color.gray);
        confirmS.setForeground(Color.gray);
    }

    private void studentFocusGained() {
        userProfileL.setForeground(Orange);
        student.setForeground(Orange);
        teacher.setForeground(Orange);
    }

    private void studentFocusLost() {
        userProfileL.setForeground(Color.gray);
        student.setForeground(Color.gray);
        teacher.setForeground(Color.gray);
    }

    private void teacherFocusGained() {
        userProfileL.setForeground(Orange);
        student.setForeground(Orange);
        teacher.setForeground(Orange);
    }

    private void teacherFocusLost() {
        userProfileL.setForeground(Color.gray);
        student.setForeground(Color.gray);
        teacher.setForeground(Color.gray);
    }

    private void cancelMouseClicked() {
        System.exit(0);
    }

    private void cancelMouseEntered() {
        cancel.setBackground(Color.GRAY);
    }

    private void cancelMouseExited() {
        cancel.setBackground(Dracula);
    }

    private void signUpMouseEntered() {
        sign_Up.setBackground(Color.GRAY);
    }

    private void signUpMouseClicked() {
        String userName = userNameF.getText();
        String eMail = E_mailF.getText();
        String password = String.valueOf(PasswordF.getPassword());
        String confirmPassword = String.valueOf(confirmF.getPassword());
        String profile;
        int idus = 0;

        if(student.isSelected())
            profile = "student";
        else
            profile ="teacher";

        if(userName.equals("")) { JOptionPane.showMessageDialog( null, "Add a user name"); }
        else if(eMail.equals("")) { JOptionPane.showMessageDialog( null, "add an email"); }
        else if(password.equals("")) { JOptionPane.showMessageDialog( null, "add a password"); }
        else if(confirmPassword.equals("")) { JOptionPane.showMessageDialog( null, "please confirm your password"); }
        else if(!password.equals(confirmPassword)) { JOptionPane.showMessageDialog( null, "password doesn't match confirmation"); }

        String query = "insert into user (email, password, username, profile)"+"VALUES (?,?,?,?)";
        String query1 = "insert into "+profile+" (idus)"+"VALUES (?)";
        String query2 = "select * from user where `email` = ? and `password`=?";
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihmer?autoReconnect=true&useSSL=false","root","dragonhead1234");
            Connection con = dbConnection.getConnection() ;
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps1 = con.prepareStatement(query1);

            ps.setString(1,eMail);
            ps.setString(2,password);
            ps.setString(3,userName);
            ps.setString(4,profile);
            ps.execute();
            ResultSet res = ps.getGeneratedKeys();
            while (res.next())
            {
                idus = res.getInt(1);
            }
            System.out.print(idus);
            ps1.setInt(1,idus);
            ps1.execute();
            //hadi kima ta3 log in copy past
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1, eMail);
            ps2.setString(2, password);
            ResultSet rs = ps2.executeQuery();

            rs.next();

            IHMer ihmer = new IHMer(rs);
            signUp.dispose();

        }catch(SQLException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog( null, ex.getMessage());
        }

    }

    private void signUpMouseExited() {
        sign_Up.setBackground(Dracula);
    }

    private void teacherActionPerformed() {
        teacher.setSelected(true);
        student.setSelected(false);
    }

    private void studentActionPerformed() {
        student.setSelected(true);
        teacher.setSelected(false);
    }
    private void SignInMouseClicked()
    {
        LogIn log = new LogIn();
        signUp.dispose();
    }
}
