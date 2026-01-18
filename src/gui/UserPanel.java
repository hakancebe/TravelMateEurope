package gui;

import model.Destination;
import db.DatabaseHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList; 
import java.util.List;

public class UserPanel extends JPanel {

    private JComboBox<String> destinationComboBox;
    private JTextArea descriptionArea;
    private JLabel imageLabel;


    private List<Destination> destinations = new ArrayList<>();
    
   
    private DatabaseHelper dbHelper = new DatabaseHelper();
    
    public UserPanel() {
    	setLayout(new BorderLayout(10, 10));
    	
    	
       	imageLabel = new JLabel();
    	imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	add(imageLabel, BorderLayout.CENTER); 
    	imageLabel.setPreferredSize(new Dimension(250, 250));
    	
        JLabel lblUserPanel = new JLabel("User Panel", SwingConstants.CENTER);
        lblUserPanel.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblUserPanel, BorderLayout.NORTH);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); 

        JLabel lblChooseADestination = new JLabel("Choose a destination");
        lblChooseADestination.setBounds(326, 11, 111, 14);
        topPanel.add(lblChooseADestination);

        destinationComboBox = new JComboBox<>();
        destinationComboBox.setBounds(326, 36, 124, 22);
        topPanel.add(destinationComboBox);
        add(topPanel, BorderLayout.NORTH);

        descriptionArea = new JTextArea(10, 50);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        add(scrollPane, BorderLayout.SOUTH);

        //Load SQL datas
        loadData();

  
        destinationComboBox.addActionListener(e -> {
            int selectedIndex = destinationComboBox.getSelectedIndex();
   
            if (selectedIndex >= 0 && selectedIndex < destinations.size()) {
                updateUI(selectedIndex);
            }
        });
        
        //Start Image
           if (!destinations.isEmpty()) {
            destinationComboBox.setSelectedIndex(0);
            updateUI(0);        
            }
    }

    private void loadData() {
 
        destinations = dbHelper.getAllDestinations();
        

        destinationComboBox.removeAllItems();
        for (Destination dest : destinations) {
            destinationComboBox.addItem(dest.getName());
        }
    }
    

    private void updateUI(int index) {
        Destination selectedDest = destinations.get(index);
        
        //Description set
        descriptionArea.setText(selectedDest.getDescription());
        
       //set image
        String path = selectedDest.getImagePath();
        
        //Check if there is an image file
        if (path != null && !path.isEmpty()) {
             ImageIcon icon = new ImageIcon(path);
             // Fit the image to the box
             Image scaled = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
             imageLabel.setIcon(new ImageIcon(scaled));
        } else {
             imageLabel.setIcon(null); // Empty if there is no image
             imageLabel.setText("No Image Found");
        }
    }
}