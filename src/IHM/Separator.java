package IHM;

import javax.swing.JSeparator;
import java.awt.*;

public class Separator extends JSeparator {

    public Separator(int x, Color color)
    {
        this.setBackground(color);
        this.setForeground(color);
        this.setRequestFocusEnabled(false);
        this.setVerifyInputWhenFocusTarget(false);
        this.setPreferredSize(new Dimension(x, 1));
    }
}
