package gui;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {
    public AdminFrame() {
        setTitle("Admin Panel");
        setSize(1300, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        AdminPanel adminPanel = new AdminPanel();
        setContentPane(adminPanel);

        setVisible(true);
    }
}
