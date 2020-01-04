import IHM.*;
import IHM.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideMenuBare extends MyPanel {
        //private Form sideMenuBar = new Form(500, 400, "side");
    private Color Orange = new Color(230, 145, 56);
    private Color WhiteOrange =new Color(255, 229, 153);

    private  MyPanel panel= new MyPanel(70 ,50 ,WhiteOrange);

    private Button fontPage = new Button(70,30,Color.BLACK,WhiteOrange,"Font Page");
    private Button blindColor = new Button(70,30,Color.BLACK,WhiteOrange,"Blind Color Mode");
    private Button language = new Button(70,30,Color.BLACK,WhiteOrange,"Language");
    private Button contacts = new Button(70,30,Color.BLACK,WhiteOrange,"Contacts");
    private Button aboutUs = new Button(70,30,Color.BLACK,WhiteOrange,"About Us");
    private ImageIcon user = new ImageIcon("logout.png");
    JButton logOut = new JButton("Log out", user);

    public  SideMenuBare(Color color)

    {
        super(color);
        logOut.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        logOut.setHorizontalTextPosition(SwingConstants.LEADING);
        logOut.setBackground(new Color(255, 229, 153));
        logOut.setForeground(Color.BLACK);
        logOut.setSize(70,30);
        panel.setLayout(new GridLayout(6, 0));
        panel.add(fontPage);
        panel.add(blindColor);
        panel.add(language);
        panel.add(contacts);
        panel.add(aboutUs);
        panel.add(logOut);


        //sideMenuBar.getContentPane().add(panel); bach nsayi bark




        fontPage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {fontPageMouseEntered();}

            @Override
            public void mouseExited(MouseEvent e) {fontPageMouseExited();}
        });

        blindColor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {blindColorMouseEntered();}

            @Override
            public void mouseExited(MouseEvent e) {blindColorMouseExited();}
        });
        language.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {languageMouseEntered();}

            @Override
            public void mouseExited(MouseEvent e) {languageMouseExited();}
        });
        contacts.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {contactsMouseEntered();}

            @Override
            public void mouseExited(MouseEvent e) {contactsMouseExited();}
        });
        aboutUs.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {aboutUsMouseClicked();}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {aboutUsMouseEntered();}

            @Override
            public void mouseExited(MouseEvent e) {aboutUsMouseExited();}
        });
        logOut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {logOutMouseClicked();}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {logOutMouseEntered();}

            @Override
            public void mouseExited(MouseEvent e) {logOutMouseExited();}
        });

        //sideMenuBar.setVisible(true);
        this.add(panel, BorderLayout.WEST);

    }



    private void fontPageMouseEntered() {
        fontPage.setBackground(Orange);
    }
    private void fontPageMouseExited() {
        fontPage.setBackground(WhiteOrange);
    }
    private void blindColorMouseEntered() {
        blindColor.setBackground(Orange);
    }
    private void blindColorMouseExited() {
        blindColor.setBackground(WhiteOrange);
    }
    private void languageMouseEntered() {
        language.setBackground(Orange);
    }
    private void languageMouseExited() {
        language.setBackground(WhiteOrange);
    }

    private void contactsMouseEntered() {
        contacts.setBackground(Orange);
    }
    private void contactsMouseExited() {
        contacts.setBackground(WhiteOrange);
    }

    private void aboutUsMouseEntered() {
        aboutUs.setBackground(Orange);
    }
    private void aboutUsMouseExited() {
        aboutUs.setBackground(WhiteOrange);
    }
    private void logOutMouseEntered() {
        logOut.setBackground(Orange);
    }
    private void logOutMouseExited() {
        logOut.setBackground(WhiteOrange);
    }

    private void logOutMouseClicked()
    {
        LogIn log= new LogIn();
       // this.dispose(); hna kanat red dunno why
    }
    private void aboutUsMouseClicked()
    {
        AboutUs about= new AboutUs();
        //this.dispose();
    }

    public static void main(String[] args) {
        SideMenuBare side = new SideMenuBare(Color.yellow); //dart yellow bach nsayi too xD
    }

}






