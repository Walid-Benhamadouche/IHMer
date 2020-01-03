package IHM;

import javax.swing.JPasswordField;
import java.awt.*;

public class PasswordField extends JPasswordField {

    private Font defaultFont = new Font("Comic Sans MS", Font.BOLD, 12);
    private Dimension defaultDim;

    public PasswordField(int x, int y, Color backGround, Color foreGround) {
        defaultDim = new Dimension(x, y);
        this.setBackground(backGround);
        this.setForeground(foreGround);
        this.setFont(defaultFont);
        this.setPreferredSize(defaultDim);
        this.setBorder(null);
    }
}
