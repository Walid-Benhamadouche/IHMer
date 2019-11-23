import IHM.*;
import IHM.Button;
import IHM.Label;
import IHM.TextField;;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LogIn {

    //declarations
    private Form logIn = new Form(720,390,"logI nT");

    private Image logInIcon;
    private Image image;
    private Color Dracula = new Color(45,52,54);
    private Color Orange = new Color(230,145,56);

    private Label SignInText = new Label("Times New Roman", Font.PLAIN, 36, Orange, "Sign In");
    private Label E_mailL = new Label("Tahoma", Font.PLAIN, 14, Orange, "E-mail");
    private Label PasswordL = new Label("Tahoma", Font.PLAIN, 14, Orange, "Password");

    private Separator E_mailS = new Separator(240, Orange);
    private Separator PasswordS = new Separator(240, Orange);

    private TextField E_mailF = new TextField(240, 30, Dracula, Orange);
    private PasswordField PasswordF = new PasswordField(240, 30, Dracula, Orange);

    private CheckBox RememberMe = new CheckBox(Dracula, Orange, "Remember me");

    private Button Cancel = new Button(80, 30, Orange, Dracula,"Cancel");
    private Button Sign_in = new Button(80, 30, Orange, Dracula,"Sign in");

    private MyPanel topPanel = new MyPanel(720, 80, Dracula);
    private MyPanel leftPanel = new MyPanel(360, 310, Dracula);
    private MyPanel rightPanel = new MyPanel(360, 310, Dracula);

    public LogIn()
    {
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
        try {
            image = ImageIO.read(new File("IHMer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        leftPanel.imageUpdate(image,0,0,0,130,50);

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

        //setting Form to visible
        logIn.setVisible(true);
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
    }
}
