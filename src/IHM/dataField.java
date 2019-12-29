package IHM;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class dataField extends Label{

    dataField(ResultSet rs) throws SQLException {
        ImageIcon lesson;
        lesson = new ImageIcon("file.png");
        this.setIcon(lesson);
        this.setText(rs.getString("name"));
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try {
                    fileMouseClicked (rs);
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

    private void fileMouseClicked(ResultSet rs) throws SQLException, IOException {
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
            InputStream input = rs.getBinaryStream("lesson");

            byte[] buffer = new byte[1024];
            while (input.read(buffer) > 0)
            {
                output.write(buffer);
                System.out.println("writing . . .");
            }
            System.out.println("writing completed");
        }
    }
}
