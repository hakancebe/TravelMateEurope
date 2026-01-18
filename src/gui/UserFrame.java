package gui;

import javax.swing.*;

public class UserFrame extends JFrame {
    public UserFrame() {
        setTitle("User Panel");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        UserPanel userPanel = new UserPanel();
        setContentPane(userPanel);

        setVisible(true);
    }
}
