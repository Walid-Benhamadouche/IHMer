package IHM;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class dataField extends Label{

    dataField(ResultSet rs,String type) throws SQLException {
        Color backColor = new Color(230, 145, 56);
        ImageIcon lesson;
        switch (type) {
            case "lesson":
                lesson = new ImageIcon("icons8-pdf-100.png");
                break;
            case "news":
                lesson = new ImageIcon("icons8-image-100.png");
                break;
            case "video":
                lesson = new ImageIcon("icons8-video-file-100.png");
                break;
            default:
                lesson = new ImageIcon("icons8-edit-file-400.png");
                break;
        }
        Dimension d= new Dimension(150,140);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setIcon(lesson);
        this.setText(rs.getString("name"));
        this.setForeground(backColor);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try {
                    fileMouseClicked (rs,type);
                } catch (SQLException | IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    private void fileMouseClicked(ResultSet rs,String type) throws SQLException, IOException {
        JLabel l = new JLabel();
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showSaveDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)

        {
            // set the label to the path of the selected file
            l.setText(j.getSelectedFile().getAbsolutePath());
        }

        //+rs.getString("name")
        File file = new File(l.getText());
        FileOutputStream output = new FileOutputStream(file);
        System.out.println("file created");
        rs.previous();
        rs.previous();
        if(rs.next())
        {
            InputStream input = rs.getBinaryStream(type);

            byte[] buffer = new byte[1024];
            while (input.read(buffer) > 0)
            {
                output.write(buffer);
                System.out.println("writing . . .");
            }
            System.out.println("writing completed");
            output.close();
        }
    }
}
