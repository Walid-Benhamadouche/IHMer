import IHM.*;
import IHM.Button;
import IHM.Label;
import IHM.TextField;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.sql.*;

public class LogIn {

    //declarations
    private Form logIn = new Form(720, 390, "Log In");

    private Image logInIcon;
    private ImageIcon logo;
    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);

    private Label SignInText = new Label("Times New Roman", Font.PLAIN, 36, Orange, "Sign In");
    private Label E_mailL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "E-mail");
    private Label PasswordL = new Label("Tahoma", Font.PLAIN, 14, Color.gray, "Password");
    private Label logoL = new Label();
    private Label eXMemberL = new Label("Tahoma", Font.PLAIN, 12, Color.lightGray, "New to IHMer ?");

    private Separator E_mailS = new Separator(240, Color.gray);
    private Separator PasswordS = new Separator(240, Color.gray);

    private TextField E_mailF = new TextField(240, 30, Dracula, Color.gray);
    private PasswordField PasswordF = new PasswordField(240, 30, Dracula, Color.gray);

    private CheckBox RememberMe = new CheckBox(Dracula, Color.gray, "Remember me");

    private Button Cancel = new Button(80, 30, Orange, Dracula, "Cancel");
    private Button Sign_in = new Button(80, 30, Orange, Dracula, "Sign in");
    private Button Sign_up = new Button(85, 18, Orange, Dracula, "Sign up");

    private MyPanel topPanel = new MyPanel(720, 80, Dracula);
    private MyPanel leftPanel = new MyPanel(360, 310, Dracula);
    private MyPanel rightPanel = new MyPanel(360, 310, Dracula);

    public LogIn() {
        try {
            logInIcon = ImageIO.read(new File("IHMerMini.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logIn.setIconImage(logInIcon);
        logIn.setLayout(new BorderLayout());
        //topPanel Configuration
        topPanel.add(SignInText);

        //leftPanel Configuration
        logo = new ImageIcon("IHMer.png");
        logoL.setIcon(logo);
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints lgbc = new GridBagConstraints();
        lgbc.weighty = 0.3;
        lgbc.fill = GridBagConstraints.NONE;
        lgbc.gridx = 0;

        //logoL-------------------------
        lgbc.gridy = 0;
        leftPanel.add(logoL, lgbc);
        //eXMember----------------------
        eXMemberL.setBackground(Color.BLACK);
        lgbc.weighty = 1;
        lgbc.anchor = GridBagConstraints.FIRST_LINE_START;
        lgbc.gridy = 1;
        leftPanel.add(eXMemberL, lgbc);
        //Sign_up-----------------------
        lgbc.gridx = 1;
        lgbc.anchor = GridBagConstraints.FIRST_LINE_START;
        leftPanel.add(Sign_up, lgbc);

        //rightPanel Configuration
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weighty = 0.5;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;

        //E_mailL-----------------------
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        rightPanel.add(E_mailL, gbc);
        //E_mailF-----------------------
        gbc.weighty = 0.1;
        gbc.gridy = 1;
        rightPanel.add(E_mailF, gbc);
        //E_mailS-----------------------
        gbc.weighty = 0.5;
        gbc.gridy = 2;
        rightPanel.add(E_mailS, gbc);
        //PasswordL---------------------
        gbc.gridy = 3;
        rightPanel.add(PasswordL, gbc);
        //PasswordF---------------------
        gbc.weighty = 0.1;
        gbc.gridy = 4;
        rightPanel.add(PasswordF, gbc);
        //PasswordS---------------------
        gbc.weighty = 0.5;
        gbc.gridy = 5;
        rightPanel.add(PasswordS, gbc);
        //RememberMe--------------------
        gbc.gridy = 6;
        rightPanel.add(RememberMe, gbc);
        //Cancel------------------------
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        rightPanel.add(Cancel, gbc);
        //Sign_in-----------------------
        gbc.gridx = 1;
        rightPanel.add(Sign_in, gbc);

        //positioning panels in the Form
        logIn.getContentPane().add(topPanel, BorderLayout.NORTH);
        logIn.getContentPane().add(leftPanel, BorderLayout.WEST);
        logIn.getContentPane().add(rightPanel, BorderLayout.CENTER);

        Cancel.addMouseListener(new MouseListener() {
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

        Sign_in.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    signInMouseClicked();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
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
                signInMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signInMouseExited();
            }
        });

        Sign_up.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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

        E_mailF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                e_mailFFocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                e_mailFFocusLost();
            }
        });

        PasswordF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                PasswordFFocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                PasswordFFocusLost();
            }
        });

        RememberMe.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                rememberMeFocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                rememberMeFocusLost();
            }
        });

        //setting Form to visible
        logIn.setResizable(false);
        logIn.setVisible(true);
    }

    public void cancelMouseClicked() {
        System.exit(0);
    }

    public void cancelMouseEntered() {
        Cancel.setBackground(Color.GRAY);
    }

    public void cancelMouseExited() {
        Cancel.setBackground(Dracula);
    }

    public void signInMouseEntered() {
        Sign_in.setBackground(Color.GRAY);
    }

    public void signInMouseExited() {
        Sign_in.setBackground(Dracula);
    }

    public void signInMouseClicked() throws SQLException, ClassNotFoundException
    {
        String email = E_mailF.getText();
        String password = String.valueOf(PasswordF.getPassword());

        String query = "select email, password from user where `email` = ? and `password`=?";

        Connection con = dbConnection.getConnection() ;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        rs.next();

        IHMer ihmer = new IHMer(rs);
        logIn.dispose();
    }

    public void e_mailFFocusGained() {
        E_mailF.setForeground(Orange);
        E_mailL.setForeground(Orange);
        E_mailS.setForeground(Orange);
    }

    public void e_mailFFocusLost() {
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

    public void rememberMeFocusGained() {
        RememberMe.setForeground(Orange);
    }

    public void rememberMeFocusLost() {
        RememberMe.setForeground(Color.gray);
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
    }
}
