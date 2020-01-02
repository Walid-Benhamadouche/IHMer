package IHM;

import javax.swing.JCheckBox;
import java.awt.*;

public class CheckBox extends JCheckBox {

    private Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 12);
    public CheckBox(Color backGround, Color foreGround, String text)
    {
        this.setBackground(backGround);
        this.setForeground(foreGround);
        this.setFont(defaultFont);
        this.setText(text);
        this.setBorder(null);
        this.setContentAreaFilled(false);
    }
}
