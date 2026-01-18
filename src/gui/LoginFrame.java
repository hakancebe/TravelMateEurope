package gui;

import javax.swing.*;

import db.DatabaseHelper;



public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private DatabaseHelper dbHelper = new DatabaseHelper();
    
    
    public LoginFrame() {
        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);


        JLabel userLabel = new JLabel("User Name:");
        userLabel.setBounds(50, 40, 100, 25);
        getContentPane().add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 40, 180, 25);
        getContentPane().add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 80, 100, 25);
        getContentPane().add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 180, 25);
        getContentPane().add(passwordField);

        JButton loginButton = new JButton("Log in");
        loginButton.setBounds(188, 116, 100, 30);
        getContentPane().add(loginButton);

        JButton userAccessButton = new JButton("User Entry");
        userAccessButton.setBounds(150, 170, 180, 30);
        getContentPane().add(userAccessButton);
        
        JLabel lblNewLabel = new JLabel("Only for user");
        lblNewLabel.setBounds(50, 174, 77, 22);
        getContentPane().add(lblNewLabel);
        
        userAccessButton.addActionListener(e -> {
            dispose();
            new UserFrame();
        });

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            boolean succes = dbHelper.checkLogin(username, password);
            
            if(succes) {
            	JOptionPane.showMessageDialog(this, "Login succeeded!");
                dispose(); 
                new AdminFrame();
            }else {
            	JOptionPane.showMessageDialog(this, "Incorrect username or password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        setVisible(true);
    }

   

  
}
