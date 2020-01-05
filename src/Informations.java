import IHM.*;
import IHM.Button;
import IHM.Label;
import IHM.TextField;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Informations {
    private Form informations = new Form(800, 600, "Account Informations");

    private Image logInIcon;
    private ImageIcon logo;
    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);
    private IHM.Label personnelInfoL = new IHM.Label("Californian FB", Font.PLAIN, 20, Orange, "Personnel Informations");
    private IHM.Label logoL = new IHM.Label();
    private IHM.Label E_mailL = new IHM.Label("Californian FB", Font.PLAIN, 18, Color.gray, "E-mail   ");
    private IHM.Label PasswordL = new IHM.Label("Californian FB", Font.PLAIN, 18, Color.gray, "Password   ");
    private IHM.Label userNameL = new IHM.Label("Californian FB", Font.PLAIN, 18, Color.gray, "User Name   ");
    private IHM.Label confirmL = new IHM.Label("Californian FB", Font.PLAIN, 18, Color.gray, "Confirm   ");
    private Separator E_mailS = new Separator(240, Color.gray);
    private Separator PasswordS = new Separator(240, Color.gray);
    private Separator userNameS = new Separator(240, Color.gray);
    private Separator confirmS = new Separator(240, Color.gray);
    private IHM.TextField E_mailF = new IHM.TextField(240, 30, Dracula, Color.gray);
    private PasswordField PasswordF = new PasswordField(240, 30, Dracula, Color.gray);
    private IHM.TextField userNameF = new TextField(240, 30, Dracula, Color.gray);
    private PasswordField confirmF = new PasswordField(240, 30, Dracula, Color.gray);

    private MyPanel topPanel = new MyPanel(800, 150, Dracula);
    private MyPanel mainPanel = new MyPanel(800, 200, Dracula);
    private MyPanel botPanel = new MyPanel(800, 60, Dracula);


    //private Button cancel = new Button(100, 50, Orange, Dracula, "Cancel");
    private Button save = new Button(100, 50, Orange, Dracula, "save");
    private int userId;

    Informations(int userId) {
        this.userId = userId;

        informations.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            logInIcon = ImageIO.read(new File("IHMerMini.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        informations.setIconImage(logInIcon);
        save.setFont(new Font("Californian FB", Font.PLAIN, 22));
        //cancel.setFont(new Font("Californian FB",Font.PLAIN,20));
        informations.setLayout(new BorderLayout());

        informations.setVisible(true);
//topPanel Configuration

        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints tgbc = new GridBagConstraints();

        tgbc.gridx = 0;
        //logoL-------------------------
        tgbc.gridy = 0;
        tgbc.weighty = 0.4;
        topPanel.add(logoL, tgbc);
        //personal information text----------------------
        tgbc.gridy = 1;
        ///tgbc.weighty= 0;
        topPanel.add(personnelInfoL, tgbc);
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

        //cancel-------------------
        /*botGbc.gridx = 1;
        botGbc.weightx = 20;
        botPanel.add(cancel, botGbc);*/
        //save button--------------
        botGbc.anchor = GridBagConstraints.FIRST_LINE_END;
        botGbc.gridx = 2;
        botPanel.add(save, botGbc);


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


        save.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                saveMouseClicked();

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
                saveMouseExited();
            }
        });

        logo = new ImageIcon("IHMer.png");

        informations.getContentPane().add(mainPanel, BorderLayout.CENTER);
        informations.getContentPane().add(topPanel, BorderLayout.NORTH);
        informations.getContentPane().add(botPanel, BorderLayout.SOUTH);
        logoL.setIcon(logo);

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

    private void cancelMouseClicked() {
        informations.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //System.exit(0);
    }

    private void saveMouseEntered() {
        save.setBackground(Color.GRAY);
    }

    ////////////////////////////////////////
    private void saveMouseClicked() {
        String userName = userNameF.getText();
        String eMail = E_mailF.getText();
        String password = String.valueOf(PasswordF.getPassword());
        String confirmPassword = String.valueOf(confirmF.getPassword());


        if (userName.equals("")) {
            JOptionPane.showMessageDialog(null, "Set a user name");
        } else if (eMail.equals("")) {
            JOptionPane.showMessageDialog(null, "Set an email");
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Set a password");
        } else if (confirmPassword.equals("")) {
            JOptionPane.showMessageDialog(null, "please confirm your password");
        } else if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "password doesn't match confirmation");
        }

        //String query = "update user where idus = '" + userId + "' Set email ='" + eMail + "' Set password = '" + password + "' Set username = '" + userName + "';";
        String query = "update user Set email = '" + eMail + "' , password = '" + password + "' , username = '" + userName + "' where idus = '" + userId + "';";

        System.out.println(query);
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihmer?autoReconnect=true&useSSL=false","root","dragonhead1234");
            Connection con = dbConnection.getConnection();
            Statement sttm = con.createStatement();
            sttm.executeUpdate(query);
            informations.dispose();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "error");
        }

    }

    private void saveMouseExited() {
        save.setBackground(Dracula);
    }
}
