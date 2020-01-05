import IHM.*;
import IHM.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideMenuBare extends MyPanel {
    private Color Dracula = new Color(45, 52, 54);
    private Color Orange = new Color(230, 145, 56);
    final static Color whiteOrange = new Color(255, 229, 153);
//private MyPanel languagePanel = new MyPanel(50, 50, whiteOrange);
private  JPanel languagePanel = new JPanel();
    private ImageIcon font = new ImageIcon("fontPage.png");
    private ImageIcon blind = new ImageIcon("blind.png");
    private ImageIcon langage = new ImageIcon("language.png");
    private ImageIcon contact = new ImageIcon("contact.png");
    private ImageIcon about = new ImageIcon("about.png");
    private ImageIcon userOut = new ImageIcon("logout.png");
    private ImageIcon frc = new ImageIcon("fracais.png");
    private ImageIcon ang = new ImageIcon("anglais.png");
    JButton fontPage = new JButton("Font Page", font);
    JButton blindColor = new JButton("Blind Color Mode", blind);
    JButton language = new JButton("Language", langage);
    JButton contacts = new JButton("Contacts", contact);
    JButton aboutUs = new JButton("About Us", about);
    JButton logOut = new JButton("Log out", userOut);
// for language panel
    JButton english = new JButton("English", ang);
    JButton frensh = new JButton("Français", frc);
    private boolean languageOpen = false;

    public SideMenuBare() {
        super(whiteOrange);
        fontPage.setFont(new Font("Californian FB", Font.BOLD, 25));
        fontPage.setHorizontalTextPosition(SwingConstants.LEADING);
        fontPage.setBackground(whiteOrange);
        fontPage.setForeground(Color.BLACK);
        fontPage.setSize(70, 30);

        blindColor.setFont(new Font("Californian FB", Font.BOLD, 25));
        blindColor.setHorizontalTextPosition(SwingConstants.LEADING);
        blindColor.setBackground(whiteOrange);
        blindColor.setForeground(Color.BLACK);
        blindColor.setSize(70, 30);

        language.setFont(new Font("Californian FB", Font.BOLD, 25));
        language.setHorizontalTextPosition(SwingConstants.LEADING);
        language.setBackground(whiteOrange);
        language.setForeground(Color.BLACK);
        language.setSize(70, 30);

        contacts.setFont(new Font("Californian FB", Font.BOLD, 25));
        contacts.setHorizontalTextPosition(SwingConstants.LEADING);
        contacts.setBackground(whiteOrange);
        contacts.setForeground(Color.BLACK);
        contacts.setSize(70, 30);

        aboutUs.setFont(new Font("Californian FB", Font.BOLD, 25));
        aboutUs.setHorizontalTextPosition(SwingConstants.LEADING);
        aboutUs.setBackground(whiteOrange);
        aboutUs.setForeground(Color.BLACK);
        aboutUs.setSize(70, 30);

        //logOut Button config
        logOut.setFont(new Font("Californian FB", Font.BOLD, 25));
        logOut.setHorizontalTextPosition(SwingConstants.LEADING);
        logOut.setBackground(whiteOrange);
        logOut.setForeground(Color.BLACK);
        logOut.setSize(70, 30);

        //english and french button config
        english.setFont(new Font("Californian FB", Font.BOLD, 25));
        english.setHorizontalTextPosition(SwingConstants.LEADING);
        english.setBackground(whiteOrange);
        english.setForeground(Color.BLACK);
        english.setSize(50, 30);
        frensh.setFont(new Font("Californian FB", Font.BOLD, 25));
        frensh.setHorizontalTextPosition(SwingConstants.LEADING);
        frensh.setBackground(whiteOrange);
        frensh.setForeground(Color.BLACK);
        frensh.setSize(50, 30);
        //languagePanel config
        /*languagePanel.setLayout(new GridLayout(2, 0));
        languagePanel.add(english);
        languagePanel.add(frensh);*/
        JPanel frcEng = new JPanel();
        frcEng.setLayout(new BorderLayout());
        frcEng.add(frensh, BorderLayout.EAST);
        frcEng.add(english, BorderLayout.WEST);
        languagePanel.setLayout(new BorderLayout());
        languagePanel.add(language, BorderLayout.CENTER);
        this.setLayout(new GridLayout(6, 0));
        this.add(fontPage);
        this.add(blindColor);
        //this.add(language);
        this.add(languagePanel);
        this.add(contacts);
        this.add(aboutUs);
        this.add(logOut);


        fontPage.addMouseListener(new MouseListener() {
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
                fontPageMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fontPageMouseExited();
            }
        });

        blindColor.addMouseListener(new MouseListener() {
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
                blindColorMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                blindColorMouseExited();
            }
        });
        language.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!languageOpen) activateLanguagePanel(frcEng);
                else hideLanguagePanel(frcEng);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                languageMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                languageMouseExited();
            }
        });
        contacts.addMouseListener(new MouseListener() {
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
                contactsMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contactsMouseExited();
            }
        });
        aboutUs.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aboutUsMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                aboutUsMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aboutUsMouseExited();
            }
        });
        logOut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logOutMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logOutMouseEntered();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logOutMouseExited();
            }
        });
        english.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hideLanguagePanel(frcEng);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) { englishMouseEntered();

            }

            @Override
            public void mouseExited(MouseEvent e) { englishMouseExited();

            }
        });
        frensh.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hideLanguagePanel(frcEng);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) { frenshMouseEntered();

            }

            @Override
            public void mouseExited(MouseEvent e) { frenshMouseExited();

            }
        });

    }

    private void activateLanguagePanel(JPanel pnnl) {

        languagePanel.add(pnnl, BorderLayout.SOUTH);
        languagePanel.revalidate();
        languagePanel.repaint();
        languageOpen = true;
    }

    private void hideLanguagePanel(JPanel pnnl){
        languagePanel.remove(pnnl);
        languagePanel.revalidate();
        languagePanel.repaint();
        languageOpen = true;
    }
    private void fontPageMouseEntered() {
        fontPage.setBackground(Orange);
    }

    private void fontPageMouseExited() {
        fontPage.setBackground(whiteOrange);
    }

    private void blindColorMouseEntered() {
        blindColor.setBackground(Orange);
    }

    private void blindColorMouseExited() {
        blindColor.setBackground(whiteOrange);
    }

    private void languageMouseEntered() {
        language.setBackground(Orange);
    }

    private void languageMouseExited() {
        language.setBackground(whiteOrange);
    }

    private void contactsMouseEntered() {
        contacts.setBackground(Orange);
    }

    private void contactsMouseExited() {
        contacts.setBackground(whiteOrange);
    }

    private void aboutUsMouseEntered() {
        aboutUs.setBackground(Orange);
    }

    private void aboutUsMouseExited() {
        aboutUs.setBackground(whiteOrange);
    }

    private void logOutMouseEntered() {
        logOut.setBackground(Orange);
    }

    private void logOutMouseExited() {
        logOut.setBackground(whiteOrange);
    }

    private void logOutMouseClicked() {
        LogIn log = new LogIn();
        // this.dispose(); hna kanat red dunno why
    }

    private void aboutUsMouseClicked() {
        AboutUs about = new AboutUs();
    }

    private void englishMouseEntered() {
        english.setBackground(Orange);
    }

    private void englishMouseExited() {
        english.setBackground(whiteOrange);
    }

    private void frenshMouseEntered() {
        frensh.setBackground(Orange);
    }

    private void frenshMouseExited() {
        frensh.setBackground(whiteOrange);
    }



    public static void main(String[] args) {
        SideMenuBare side = new SideMenuBare();
    }

}






