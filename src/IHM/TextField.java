package IHM;

import javax.swing.JTextField;
import java.awt.*;

public class TextField extends JTextField {

    private Font defaultFont = new Font("Tahoma", Font.BOLD, 12);
    private Dimension defaultDim;
    public TextField(int x, int y, Color backGround, Color foreGround)
    {
        defaultDim = new Dimension(x, y);
        this.setBackground(backGround);
        this.setForeground(foreGround);
        this.setFont(defaultFont);
        this.setPreferredSize(defaultDim);
        this.setBorder(null);
    }
}
