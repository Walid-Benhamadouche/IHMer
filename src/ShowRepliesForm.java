import IHM.Form;
import IHM.Label;
import IHM.MyPanel;
import IHM.TextArea;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.BLACK;

public class ShowRepliesForm {
    //declaration
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Form repliesForm = new Form(screenSize.width, screenSize.height, "Replies");
    private Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);

    private Color Orange = new Color(230, 145, 56);
    final static Color whiteOrange = new Color(255, 229, 153);
    private MyPanel panelQst = new MyPanel(Dracula);



//QST SELECTED STUFF
    private MyPanel questionSelectedPnl = new MyPanel(Dracula);
    private IHM.Label userL = new IHM.Label();
    private ImageIcon userIcon = new ImageIcon("user.png");
    private IHM.Label userNameL = new IHM.Label("Californian FB", Font.PLAIN, 20, backColor, "Malek Benzerga");
    private IHM.Label qstqst = new Label();

    //REPLIES Stuff
    private MyPanel repliesQuestion = new MyPanel(Dracula);

//replay place
private MyPanel postRPLPanel = new MyPanel(Dracula);
    private IHM.TextArea rplPoseLabel = new TextArea(300, 30, new Color(255, 229, 153), new Color(49, 53, 57));
    private JButton postButton = new JButton();

    public JPanel wrapInPanel(Component component) {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(component);
        panel.setOpaque(false);
        return panel;
    }

public ShowRepliesForm(Question q){
    ArrayList <Replie> r=q.getReplies();
    panelQst.setLayout(new GridLayout(3,1));
    panelQst.setLayout(new BorderLayout());
    userNameL.setText(q.getUserName());
   /* qstqst.setSize(700,200);
    qstqst.setFont(new Font("Californian FB", Font.BOLD, 20));
    qstqst.setBackground(Color.red);
    qstqst.setText(q.getQst());
    qstqst.setBorder(new LineBorder(Color.BLACK,1));
    qstqst.setOpaque(true);
*/


    qstqst.setSize(700, 200);
    qstqst.setFont(new Font("Californian FB", Font.BOLD, 20));
    qstqst.setBackground(Color.WHITE);
    qstqst.setBackground(Color.WHITE);
    qstqst.setForeground(BLACK);
    qstqst.setText("<html><center>"+q.getQst()+"</center></html>");

    qstqst.setBorder(new CompoundBorder(new EmptyBorder(10, 100, 10, 100),
            new LineBorder(Color.BLACK, 1, true)));
    qstqst.setOpaque(true);

    qstqst.setBorder(new LineBorder(BLACK, 1));

    //questionSelectedPnl.setBorder(new LineBorder(Color.BLACK,1));
//    questionSelectedPnl.setBorder(new LineBorder(BLACK, 1));
    userL.setIcon(userIcon);

    questionSelectedPnl.setLayout(new GridBagLayout());
    questionSelectedPnl.setLayout(new GridLayout(5, 1, 0, 0));

   // questionSelectedPnl.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    //UserIconL
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    questionSelectedPnl.add(new MyPanel(Dracula), gbc);
    questionSelectedPnl.add(wrapInPanel(userL), gbc);
    //UserNameL
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    questionSelectedPnl.add(wrapInPanel(userNameL), gbc);
    ///QSTQSTLabel
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    questionSelectedPnl.add(qstqst, gbc);
    questionSelectedPnl.setBackground(whiteOrange);
////////////////////////////////////////////////////////////////////////// ///////////////qstSelectedPanel done
    repliesQuestion.setLayout(new GridLayout(r.size()+1,1));
    for (Replie rep :r) {
        repliesQuestion.add(new SingleReplyPan(rep),BorderLayout.CENTER);
        //replyBtn.setText("Show Replies: "+q.getRepliesCnter()+ " Replies");


       // wnd.add(bigPanel);

    }

    //reply area
    postButton.setText("Post question");
    postButton.setSize(200, 40);
    postButton.setBackground(backColor);
    postButton.setForeground(Dracula);
    postButton.setFont(new Font("Californian FB", Font.BOLD, 18));
    //postQstPanel
    postRPLPanel.add(rplPoseLabel);
    postRPLPanel.add(postButton);

    panelQst.add(questionSelectedPnl,BorderLayout.NORTH);
    panelQst.add(new JScrollPane(repliesQuestion), BorderLayout.CENTER);
    panelQst.add(postRPLPanel, BorderLayout.SOUTH);
    repliesForm.setContentPane(new MyPanel(Dracula));
    repliesForm.getContentPane().setLayout(new FlowLayout());
    repliesForm.getContentPane().add(panelQst);
    repliesForm.setVisible(true);
}
    /* public static void main(String[] args) {
    Question q = new Question("lol","babababg?");
        ArrayList <Replie> repl= new ArrayList<>();
       Replie b = new Replie("mmmm","chakh vhakh!");
        Replie v = new Replie("mkkkh hhh"," vhakh!");
        repl.add(b);
        repl.add(v);
        ShowRepliesForm replie = new ShowRepliesForm(q);
    }


     */
}
