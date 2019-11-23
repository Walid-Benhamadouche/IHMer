package IHM;

import javax.swing.JPanel;
import java.awt.*;

public class MyPanel extends JPanel{

    public MyPanel(int x, int y, Color color)
    {
        this.setBackground(color);
        this.setPreferredSize(new Dimension(x, y));
    }

}
