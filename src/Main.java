import gui.LoginFrame;
import db.DatabaseHelper;

public class Main {
    public static void main(String[] args) {
    	new DatabaseHelper().initializeDatabase();
        javax.swing.SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}
