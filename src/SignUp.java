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

    private Label joinUsText = new Label("Times New Roman", Font.PLAIN, 25, Orange, "   Join us");
    private Label logoL = new Label();
    private Label E_mailL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "E-mail   ");
    private Label PasswordL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Password   ");
    private Label userNameL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "User Name   ");
    private Label confirmL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Confirm   ");
    private Label userProfileL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "User Profile   ");
    private Label alreadyMember = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "       Already a member ?");

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

        teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherActionPerformed();
            }
        });

        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentActionPerformed();
            }
        });

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

        sign_Up.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    signUpMouseClicked();
                } catch (SQLException ex) {
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

    public static void main(String[] args) {
        // hada l code ta3 netbeans li bach yakhrj l cursseur mais ra7o seperatotrs :')
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        SignUp signup = new SignUp();
    }

    public void userNameFFocusGained() {
        userNameF.setForeground(Orange);
        userNameL.setForeground(Orange);
        userNameS.setForeground(Orange);
    }

    public void userNameFFocusLost() {
        userNameF.setForeground(Color.gray);
        userNameL.setForeground(Color.gray);
        userNameS.setForeground(Color.gray);
    }

    public void E_mailFFocusGained() {
        E_mailF.setForeground(Orange);
        E_mailL.setForeground(Orange);
        E_mailS.setForeground(Orange);
    }

    public void E_mailFFocusLost() {
        E_mailF.setForeground(Color.gray);
        E_mailL.setForeground(Color.gray);
        E_mailS.setForeground(Color.gray);
    }

    public void PasswordFFocusGained() {
        PasswordF.setForeground(Orange);
        PasswordL.setForeground(Orange);
        PasswordS.setForeground(Orange);
    }

    public void PasswordFFocusLost() {
        PasswordF.setForeground(Color.gray);
        PasswordL.setForeground(Color.gray);
        PasswordS.setForeground(Color.gray);
    }

    public void confirmFFocusGained() {
        confirmF.setForeground(Orange);
        confirmL.setForeground(Orange);
        confirmS.setForeground(Orange);
    }

    public void confirmFFocusLost() {
        confirmF.setForeground(Color.gray);
        confirmL.setForeground(Color.gray);
        confirmS.setForeground(Color.gray);
    }

    public void studentFocusGained() {
        userProfileL.setForeground(Orange);
        student.setForeground(Orange);
        teacher.setForeground(Orange);
    }

    public void studentFocusLost() {
        userProfileL.setForeground(Color.gray);
        student.setForeground(Color.gray);
        teacher.setForeground(Color.gray);
    }

    public void teacherFocusGained() {
        userProfileL.setForeground(Orange);
        student.setForeground(Orange);
        teacher.setForeground(Orange);
    }

    public void teacherFocusLost() {
        userProfileL.setForeground(Color.gray);
        student.setForeground(Color.gray);
        teacher.setForeground(Color.gray);
    }

    public void cancelMouseClicked() {
        System.exit(0);
    }

    public void cancelMouseEntered() {
        cancel.setBackground(Color.GRAY);
    }

    public void cancelMouseExited() {
        cancel.setBackground(Dracula);
    }

    public void signUpMouseEntered() {
        sign_Up.setBackground(Color.GRAY);
    }

    public void signUpMouseClicked() throws SQLException {
        String userName = userNameF.getText();
        String eMail = E_mailF.getText();
        String password = String.valueOf(PasswordF.getPassword());
        String confirmPassword = String.valueOf(confirmF.getPassword());

        if(userName.equals("")) { JOptionPane.showMessageDialog( null, "Add a user name"); }
        else if(eMail.equals("")) { JOptionPane.showMessageDialog( null, "add an email"); }
        else if(password.equals("")) { JOptionPane.showMessageDialog( null, "add a password"); }
        else if(confirmPassword.equals("")) { JOptionPane.showMessageDialog( null, "please confirm your password"); }
        else if(!password.equals(confirmPassword)) { JOptionPane.showMessageDialog( null, "password doesn't match confirmation"); }

        String query = "INSERT INTO user (email,password,username) VALUES ("+eMail+","+password+","+userName+")";

        try
        {
            Statement stm = dbConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(query);

        }catch(SQLException ex)
        {

        }
    }

    public void signUpMouseExited() {
        sign_Up.setBackground(Dracula);
    }

    public void teacherActionPerformed() {
        teacher.setSelected(true);
        student.setSelected(false);
    }

    public void studentActionPerformed() {
        student.setSelected(true);
        teacher.setSelected(false);
    }
}
