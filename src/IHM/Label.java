package IHM;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel{

    public Label()
    {}

    public Label(String FontName,int FontType, int Size, Color foreGround, String text)
    {
        this.setFont(new Font(FontName, FontType, Size));
        this.setForeground(foreGround);
        this.setText(text);
    }
}
