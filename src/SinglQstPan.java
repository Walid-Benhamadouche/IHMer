import IHM.Label;
import IHM.MyPanel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Color.BLACK;

public class SinglQstPan extends MyPanel {
    private static Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);

    //private MyPanel fieldQuestion = new MyPanel(Dracula);
    private Label userL = new Label();
    private ImageIcon userIcon = new ImageIcon("user.png");
    private Label userNameL = new Label("Californian FB", Font.PLAIN, 20, backColor, "Malek Benzerga");
    // private IHM.TextArea qstqst = new TextArea(700, 100, new Color(255, 229, 153), new Color(49, 53, 57));
    private Label qstqst = new Label();
    private JButton replyBtn = new JButton();

    //private Label replyNumber = new Label("Californian FB", Font.PLAIN, 20, backColor, "11 Reply");

    public JPanel wrapInPanel(Component component) {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(component);
        panel.setOpaque(false);
        return panel;
    }

    public SinglQstPan(Question q) {
        super(Dracula);

        userNameL.setText(q.getUserName());
        userNameL.setFont(new Font("Californian FB", Font.BOLD, 24));
        userNameL.setForeground(Color.BLACK);

        replyBtn.setText("Show Replies (" + q.getRepliesCnter() + ")");
        replyBtn.setSize(200, 40);
        replyBtn.setBackground(backColor);
        replyBtn.setForeground(Dracula);
        replyBtn.setFont(new Font("Californian FB", Font.BOLD, 18));

        qstqst.setSize(700, 200);
        qstqst.setFont(new Font("Californian FB", Font.BOLD, 20));
        qstqst.setBackground(Color.WHITE);
        this.setBackground(Color.WHITE);
        qstqst.setForeground(BLACK);
        qstqst.setText("<html><center>"+q.getQst()+"</center></html>");

        //qstqst.setBorder(new LineBorder(BLACK, 1));
       // qstqst.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //qstqst.setBorder(new EmptyBorder(10, 100, 10, 100));
        qstqst.setBorder(new CompoundBorder(new EmptyBorder(10, 100, 10, 100),
                                            new LineBorder(Color.BLACK, 1, true)));
        qstqst.setOpaque(true);

        this.setBorder(new LineBorder(BLACK, 1));
        userL.setIcon(userIcon);

        this.setLayout(new GridBagLayout());
        this.setLayout(new GridLayout(4, 1, 20, 5));
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagConstraints gbc = new GridBagConstraints();
        //UserIconL
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(wrapInPanel(userL), gbc);
        //UserNameL
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(wrapInPanel(userNameL), gbc);
        ///QSTQSTLabel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(qstqst, gbc);
        //replyButtn
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(wrapInPanel(replyBtn), gbc);
        //this.add(fieldQuestion);
        replyBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ShowRepliesForm replies = new ShowRepliesForm(q);
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
    }

}
