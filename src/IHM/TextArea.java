package IHM;

import javax.swing.*;
import java.awt.*;

class TextArea extends JTextArea
{
    TextArea(int x, int y, Color backGround, Color foreGround)
    {
        Dimension defaultDim;
        defaultDim = new Dimension(x, y);
        this.setBackground(backGround);
        this.setForeground(foreGround);
        Font defaultFont = new Font("Tahoma", Font.BOLD, 12);
        this.setFont(defaultFont);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setPreferredSize(defaultDim);
        this.setBorder(null);
    }
}
