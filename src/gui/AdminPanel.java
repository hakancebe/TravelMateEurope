package gui;

import javax.swing.*;

import db.DatabaseHelper;

import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JPanel {
    private JTextField textField, textField_1, textField_2, textField_3,textField_4;
    private JTextField textField_5, textField_6, textField_7, textField_8, textField_9, textField_10,textField_11;
    private JTextField textField_12;

    String url = "jdbc:sqlite:gui.db";
    String tableName1 = "Country";
    String tableName2 = "City";
    String tableName3 = "Category";
    String tableName4 = "Destination";
   
 
    private DatabaseHelper dbHelper = new DatabaseHelper();
    
    public AdminPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(1300, 500)); 
        
        setupComponents();
    }


    
    private void setupComponents() {
    	//Image Update
    	JLabel lblImagePath = new JLabel("Image Path");
    	lblImagePath.setFont(new Font("Arial Black", Font.BOLD, 10));
    	lblImagePath.setBounds(931, 407, 126, 26); 
    	add(lblImagePath);

    	
    	JTextField textField_imagePath = new JTextField();
    	textField_imagePath.setBounds(1050, 410, 114, 19);
    	add(textField_imagePath);

    	
    	JButton btnUpdateImagePath = new JButton("Update Image");
    	btnUpdateImagePath.setFont(new Font("Arial Black", Font.BOLD, 10));
    	btnUpdateImagePath.setBounds(1040, 444, 126, 26);
    	add(btnUpdateImagePath);
    	
    	btnUpdateImagePath.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	try {
    	            int id = Integer.parseInt(textField_6.getText()); 
    	            String image_path = textField_imagePath.getText(); 

                    
    	            boolean success = dbHelper.updateDestinationImage(id, image_path);
    	            
    	            if (success) {
    	                JOptionPane.showMessageDialog(null, "Image path updated successfully!");
    	            } else {
    	                JOptionPane.showMessageDialog(null, "Error updating image path! Check if ID exists.");
    	            }
    	        } catch (NumberFormatException ex) {
    	            JOptionPane.showMessageDialog(null, "Please enter a valid Destination ID!");
    	        }
    	    }
    	});
    	//Countries
        JLabel lblCountries = new JLabel("Country");
        lblCountries.setFont(new Font("Arial Black", Font.BOLD, 13));
        lblCountries.setBounds(32, 47, 153, 37);
        add(lblCountries);

        JLabel lblID = new JLabel("ID:");
        lblID.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblID.setBounds(32, 128, 100, 26);
        add(lblID);

        textField = new JTextField();
        textField.setBounds(150, 132, 96, 19);
        add(textField);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblName.setBounds(31, 174, 126, 26);
        add(lblName);

        textField_1 = new JTextField();
        textField_1.setBounds(150, 178, 96, 19);
        add(textField_1);

        JButton btnNew1 = new JButton("NEW RECORD");
        btnNew1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try

		        {
					int id = Integer.parseInt(textField.getText());
		        	String name = textField_1.getText();
		        
					boolean succes = dbHelper.addCountry(id, name);
		        	
		        	if(succes) {
		        		JOptionPane.showMessageDialog(null, "The Country has been added successfully");
		        		textField.setText("");
		        		textField_1.setText("");
		        		
		        	}else {
		        		JOptionPane.showMessageDialog(null, "Fail. Could not add record");

		        	}
		        	
		        	
			}
				 catch(NumberFormatException ex)
		        {

					 JOptionPane.showMessageDialog(null, "Please enter a valid number in the ID field!");
		        }
			}	
		});
        btnNew1.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew1.setBounds(126, 212, 120, 26);
        add(btnNew1);
        
     
     //City   
        JLabel lblCity = new JLabel("City");
        lblCity.setFont(new Font("Arial Black", Font.BOLD, 13));
        lblCity.setBounds(322, 47, 153, 37);
        add(lblCity);
        
        JLabel lblID_1 = new JLabel("ID:");
        lblID_1.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblID_1.setBounds(322, 128, 100, 26);
        add(lblID_1);
        
        JLabel lblName_1 = new JLabel("Name");
        lblName_1.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblName_1.setBounds(322, 174, 126, 26);
        add(lblName_1);
        
        textField_2 = new JTextField();
        textField_2.setBounds(446, 130, 96, 19);
        add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setBounds(446, 176, 96, 19);
        add(textField_3);
        
        
        textField_12 = new JTextField();
        textField_12.setBounds(446, 215, 96, 19);
        add(textField_12);
        
        
        JButton btnNew2= new JButton("NEW RECORD");
        btnNew2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        
			try
			
			{	
				int id = Integer.parseInt(textField_2.getText());
	        	String name = textField_3.getText();
	        	int country_id =  Integer.parseInt(textField_12.getText());
	        	
	        	boolean succes = dbHelper.addCity(id, name, country_id);
	        	
	        	if(succes) {
	        		JOptionPane.showMessageDialog(null, "The City has been added successfully");
	        		textField_2.setText("");
	        		textField_3.setText("");
	        		textField_12.setText("");
	        		
	        	}else {
	        		JOptionPane.showMessageDialog(null, "Fail. Could not add record");

	        	}
	        	
	        	
		}
			 catch(NumberFormatException ex)
	        {

				 JOptionPane.showMessageDialog(null, "Please enter a valid number in the ID field!");
	        }
	}});
        
       
        btnNew2.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew2.setBounds(422, 266, 120, 26);
        add(btnNew2);
        
        //Category
        JLabel lblCategory = new JLabel("Category");
        lblCategory.setFont(new Font("Arial Black", Font.BOLD, 13));
        lblCategory.setBounds(624, 47, 153, 37);
        add(lblCategory);
        
        JLabel lblID_1_1 = new JLabel("ID:");
        lblID_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblID_1_1.setBounds(624, 128, 100, 26);
        add(lblID_1_1);
        
        JLabel lblName_1_1 = new JLabel("Name");
        lblName_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblName_1_1.setBounds(624, 174, 126, 26);
        add(lblName_1_1);
        
        textField_4 = new JTextField();
        textField_4.setBounds(748, 130, 96, 19);
        add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setBounds(748, 176, 96, 19);
        add(textField_5);
        
        JButton btnNew3 = new JButton("NEW RECORD");
        btnNew3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	try 
        	{
        		
        	int id = Integer.parseInt(textField_4.getText());
        	String category_name = textField_5.getText();
        	
        	boolean succes = dbHelper.addCategory(id, category_name);
        	
        	if(succes) {
        		JOptionPane.showMessageDialog(null, "The Category has been added successfully");
        		textField_4.setText("");
        		textField_5.setText("");
        		
        	}else {
        		JOptionPane.showMessageDialog(null, "Fail. Could not add record");

        	}
        	
        	
        	}
		 catch(NumberFormatException ex)
        {

			 JOptionPane.showMessageDialog(null, "Please enter a valid number in the ID field!");
        }
        	
        	
   }});
        btnNew3.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew3.setBounds(724, 212, 120, 26);
        add(btnNew3);
        
        //Destination
        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setFont(new Font("Arial Black", Font.BOLD, 13));
        lblDestination.setBounds(931, 47, 153, 37);
        add(lblDestination);
        
        JLabel lblID_1_2 = new JLabel("ID:");
        lblID_1_2.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblID_1_2.setBounds(931, 128, 100, 26);
        add(lblID_1_2);
        
        JLabel lblName_1_2 = new JLabel("Name");
        lblName_1_2.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblName_1_2.setBounds(931, 174, 126, 26);
        add(lblName_1_2);
        
        textField_6 = new JTextField();
        textField_6.setBounds(1055, 130, 96, 19);
        add(textField_6);
        
        textField_7= new JTextField();
        textField_7.setBounds(1055, 176, 96, 19);
        add(textField_7);
        
        textField_8 = new JTextField();
        textField_8.setBounds(1055, 210, 96, 19);
        add(textField_8);
        
        textField_9 = new JTextField();
        textField_9.setBounds(1055, 249, 96, 19);
        add(textField_9);
        
        textField_10 = new JTextField();
        textField_10.setBounds(1055, 291, 96, 19);
        add(textField_10);
        
        textField_11 = new JTextField();
        textField_11.setBounds(1055, 337, 96, 19);
        add(textField_11);
        
        JButton btnNew4 = new JButton("NEW RECORD");
        btnNew4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
    			try
    	        {	
    				int id = Integer.parseInt(textField_6.getText());
                	String destination_name  = textField_7.getText();
                	String description = textField_8.getText();
                	int city_id = Integer.parseInt(textField_9.getText());
                	int category_id = Integer.parseInt(textField_10.getText());
                	String cost_level = textField_11.getText();
                	
                boolean succes = dbHelper.addDestination(id, destination_name, description, city_id, category_id, cost_level);	
                
                if(succes) {
            		JOptionPane.showMessageDialog(null, "The Destination has been added successfully");
            		textField_6.setText("");
            		textField_7.setText("");
            		textField_8.setText("");
            		textField_9.setText("");
            		textField_10.setText("");
            		textField_11.setText("");
            		
            	}else {
            		JOptionPane.showMessageDialog(null, "Fail. Could not add record");

            	}
            	
            	
            	}
    		 catch(NumberFormatException ex)
            {

    			 JOptionPane.showMessageDialog(null, "Please enter a valid number in the ID field!");
            }
    		}	
    	});
        btnNew4.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew4.setBounds(1040, 373, 120, 26);
        add(btnNew4);
        
        JLabel lblDesc = new JLabel("Description");
        lblDesc.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblDesc.setBounds(931, 211, 126, 26);
        add(lblDesc);
        
       
        
        JLabel lblCityID = new JLabel("CityID");
        lblCityID.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblCityID.setBounds(931, 249, 126, 26);
        add(lblCityID);
        
        JLabel lblCategory1 = new JLabel("CategoryID");
        lblCategory1.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblCategory1.setBounds(931, 289, 126, 26);
        add(lblCategory1);
        
        JLabel lblCostLevel = new JLabel("CostLevel");
        lblCostLevel.setFont(new Font("Arial Black", Font.BOLD, 10));
        lblCostLevel.setBounds(931, 335, 126, 26);
        add(lblCostLevel);
        
     
        JLabel CountryID = new JLabel("CountryID");
        CountryID.setFont(new Font("Arial Black", Font.BOLD, 10));
        CountryID.setBounds(322, 212, 126, 26);
        add(CountryID);
        
        JButton btnNew1_1 = new JButton("DELETE");
        btnNew1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNew1_1.setText("DELETE"); 
        		btnNew1_1.addActionListener(new ActionListener() {
        		    public void actionPerformed(ActionEvent e) {
        		        
        		        String idText = textField.getText().trim(); 
        		        
        		       
        		        if (idText.isEmpty()) {
        		            JOptionPane.showMessageDialog(null, "Please enter the ID to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
        		            return;
        		        }

        		        try {
        		            
        		            int id = Integer.parseInt(idText);
        		            
        		           
        		            int confirm = JOptionPane.showConfirmDialog(null, 
        		                "Are you sure you want to delete the record with ID: " + id + "?", 
        		                "Confirm Deletion", 
        		                JOptionPane.YES_NO_OPTION);
        		            
        		            if (confirm == JOptionPane.YES_OPTION) {
        		                
        		                dbHelper.deleteCountry(id); 
        		                
        		            
        		                JOptionPane.showMessageDialog(null, "Record with ID " + id + " has been deleted.");
        		                textField.setText(""); 

        		            }
        		            
        		        } catch (NumberFormatException ex) {
        		            // Error handling for non-numeric input
        		            JOptionPane.showMessageDialog(null, "Error: ID must be a numeric value!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        		        }
        		    }
        		});
        	}
        });
        btnNew1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew1_1.setBounds(126, 249, 120, 26);
        add(btnNew1_1);
        
        JButton btnNew1_2 = new JButton("DELETE");
        btnNew1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                
		        String idText = textField_2.getText().trim(); 
		        
		       
		        if (idText.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter the ID to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        try {
		            
		            int id = Integer.parseInt(idText);
		            
		           
		            int confirm = JOptionPane.showConfirmDialog(null, 
		                "Are you sure you want to delete the record with ID: " + id + "?", 
		                "Confirm Deletion", 
		                JOptionPane.YES_NO_OPTION);
		            
		            if (confirm == JOptionPane.YES_OPTION) {
		                
		                dbHelper.deleteCity(id); 
		                
		            
		                JOptionPane.showMessageDialog(null, "Record with ID " + id + " has been deleted.");
		                textField.setText(""); 

		            }
		            
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Error: ID must be a numeric value!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
		        }
        	}
        });
        btnNew1_2.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew1_2.setBounds(422, 303, 120, 26);
        add(btnNew1_2);
        
        JButton btnNew1_3 = new JButton("DELETE");
        btnNew1_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                
		        String idText = textField_4.getText().trim(); 
		        
		       
		        if (idText.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter the ID to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        try {
		            
		            int id = Integer.parseInt(idText);
		            
		           
		            int confirm = JOptionPane.showConfirmDialog(null, 
		                "Are you sure you want to delete the record with ID: " + id + "?", 
		                "Confirm Deletion", 
		                JOptionPane.YES_NO_OPTION);
		            
		            if (confirm == JOptionPane.YES_OPTION) {
		                
		                dbHelper.deleteCategory(id); 
		                
		            
		                JOptionPane.showMessageDialog(null, "Record with ID " + id + " has been deleted.");
		                textField.setText(""); 

		            }
		            
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Error: ID must be a numeric value!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
		        }
        	}
        });
        btnNew1_3.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew1_3.setBounds(724, 249, 120, 26);
        add(btnNew1_3);
        
        JButton btnNew1_4 = new JButton("DELETE");
        btnNew1_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                
		        String idText = textField_6.getText().trim(); 
		        
		       
		        if (idText.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter the ID to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        try {
		            
		            int id = Integer.parseInt(idText);
		            
		           
		            int confirm = JOptionPane.showConfirmDialog(null, 
		                "Are you sure you want to delete the record with ID: " + id + "?", 
		                "Confirm Deletion", 
		                JOptionPane.YES_NO_OPTION);
		            
		            if (confirm == JOptionPane.YES_OPTION) {
		                
		                dbHelper.deleteDestination(id); 
		                
		            
		                JOptionPane.showMessageDialog(null, "Record with ID " + id + " has been deleted.");
		                textField.setText(""); 

		            }
		            
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Error: ID must be a numeric value!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
		        }
        	}
        });
        
        
        btnNew1_4.setFont(new Font("Arial Black", Font.BOLD, 10));
        btnNew1_4.setBounds(899, 373, 120, 26);
        add(btnNew1_4);
    }
}
