import IHM.Label;
import IHM.MyPanel;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class SingleReplyPan extends MyPanel {
    private static Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);

    //private MyPanel fieldQuestion = new MyPanel(Dracula);
    private IHM.Label userReplyL = new IHM.Label();
    private ImageIcon userReplyIcon = new ImageIcon("user.png");
    private IHM.Label userReplyNameL = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Malek Benzerga");
    private IHM.Label replyreply = new Label();

    public JPanel wrapInPanel(Component component) {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(component);
        panel.setOpaque(false);
        return panel;
    }

    public SingleReplyPan(Replie q){
        super(Dracula);
        userReplyNameL.setText(q.getUserNameReplie());

        userReplyNameL.setText(q.getUserNameReplie());
        userReplyNameL.setFont(new Font("Californian FB", Font.BOLD, 24));
        userReplyNameL.setForeground(Color.BLACK);

        replyreply.setSize(700, 30);
        replyreply.setFont(new Font("Californian FB", Font.BOLD, 20));
        replyreply.setBackground(Color.WHITE);
        this.setBackground(Color.WHITE);
        replyreply.setForeground(BLACK);
        replyreply.setText("<html><center>"+q.getTextReplie()+"</center></html>");


        replyreply.setBorder(new CompoundBorder(new EmptyBorder(10, 100, 10, 100),
                new LineBorder(Color.BLACK, 1, true)));
        replyreply.setOpaque(true);

        this.setBorder(new LineBorder(BLACK, 1));
        userReplyL.setIcon(userReplyIcon);


        this.setLayout(new GridBagLayout());
        this.setLayout(new GridLayout(3, 1, 20, 5));
        this.setLayout(new BorderLayout());


       // this.setBorder(new LineBorder(Color.BLACK,1));
        //userReplyL.setIcon(userReplyIcon);

        //this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //UserIconReplyL
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        MyPanel userPanel = new MyPanel(Color.WHITE);
        userPanel.setLayout(new BorderLayout());
        userPanel.add(wrapInPanel(userReplyL), BorderLayout.CENTER);
        userPanel.add(wrapInPanel(userReplyNameL), BorderLayout.SOUTH);

        this.add(wrapInPanel(userPanel), BorderLayout.WEST);
        //UserNameReplyL
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        ///ReplyReplyLabel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(replyreply, BorderLayout.CENTER);

        //this.add(fieldQuestion);

    }
}
