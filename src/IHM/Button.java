package IHM;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseListener;

public class Button extends JButton {

    public Button(int x, int y, Color foreGround, Color backGround, String name)
    {
        Font defaultFont = new Font("Tahoma", Font.BOLD, 12);
        Dimension defaultDim = new Dimension(x, y);
        this.setText(name);
        this.setBackground(backGround);
        this.setForeground(foreGround);
        this.setFont(defaultFont);
        this.setPreferredSize(defaultDim);
        this.setBorderPainted(false);
        this.setContentAreaFilled(true);
    }
}
