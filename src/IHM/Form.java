package IHM;

import javax.swing.JFrame;

public class Form extends JFrame{

    public Form(int x, int y, String title)
    {
        this.setTitle(title);
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
