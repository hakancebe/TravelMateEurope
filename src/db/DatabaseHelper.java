package db;
import model.Destination;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper {

private static final String URL = "jdbc:sqlite:gui.db";

//connect
private Connection connect() throws SQLException {
	return DriverManager.getConnection(URL);
}

//1.initializing first 1. table

public void initializeDatabase() {
	String[] createTables = {
			"CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL UNIQUE, password TEXT NOT NULL);",
            "INSERT OR IGNORE INTO users (username, password) VALUES ('admin', '1234');",
            "CREATE TABLE IF NOT EXISTS Country (id INTEGER PRIMARY KEY, country_name VARCHAR);",
            "CREATE TABLE IF NOT EXISTS City (id INTEGER PRIMARY KEY, city_name VARCHAR, country_id INTEGER, FOREIGN KEY (country_id) REFERENCES Country(id));",
            "CREATE TABLE IF NOT EXISTS Category (id INTEGER PRIMARY KEY, category_name VARCHAR);",
            "CREATE TABLE IF NOT EXISTS Destination (id INTEGER PRIMARY KEY, destination_name VARCHAR, description TEXT, city_id INTEGER, category_id INTEGER, cost_level VARCHAR, image_path TEXT, FOREIGN KEY (city_id) REFERENCES City(id), FOREIGN KEY (category_id) REFERENCES Category(id));"
	};
	
	try(Connection conn = connect(); Statement stmt = conn.createStatement()){
		for(String sql: createTables) {
			stmt.execute(sql);
		}
		System.out.println("Database and tables checked");
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
}
//2.login check
public boolean checkLogin(String username, String password) {
	String query = "SELECT * FROM users WHERE username = ? AND password = ?";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
//3. Adding data methods
public boolean addCountry(int id, String name) {
    String query = "INSERT INTO Country (id, country_name) VALUES(?, ?)";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
//Add City
public boolean addCity(int id, String name, int countryId) {
    String query = "INSERT INTO City (id, city_name, country_id) VALUES(?, ?, ?)";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, countryId);
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
//Add Category
public boolean addCategory(int id, String name) {
    String query = "INSERT INTO Category (id, category_name) VALUES(?, ?)";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
//Add Destination
public boolean addDestination(int id, String name, String description, int cityId, int categoryId, String costLevel) {
    String query = "INSERT INTO Destination (id, destination_name, description, city_id, category_id, cost_level) VALUES(?, ?, ?, ?, ?, ?)";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, description);
        pstmt.setInt(4, cityId);
        pstmt.setInt(5, categoryId);
        pstmt.setString(6, costLevel);
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } 
}
//4. Update Image
public boolean updateDestinationImage(int id, String imagePath) {
    String query = "UPDATE Destination SET image_path = ? WHERE id = ?";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, imagePath);
        pstmt.setInt(2, id);
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

//5. User Panel
public List<Destination> getAllDestinations() {
    List<Destination> list = new ArrayList<>();
    String query = "SELECT id, destination_name, description, city_id, category_id, cost_level, image_path FROM Destination ORDER BY destination_name";
    
    try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            list.add(new Destination(
                rs.getInt("id"),
                rs.getString("destination_name"),
                rs.getString("description"),
                rs.getInt("city_id"),
                rs.getInt("category_id"),
                rs.getString("cost_level"),
                rs.getString("image_path")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

//Delete Destination
public void deleteDestination(int id) {
    String sql = "DELETE FROM Destination WHERE id = ?";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("Destination deleted successfully.");
    } catch (SQLException e) {
        System.out.println("Error deleting destination: " + e.getMessage());
    }
}

//Delete Category
public void deleteCategory(int id) {
 String sql = "DELETE FROM Category WHERE id = ?";
 try (Connection conn = this.connect();
      PreparedStatement pstmt = conn.prepareStatement(sql)) {
     pstmt.setInt(1, id);
     pstmt.executeUpdate();
     System.out.println("Category deleted successfully.");
 } catch (SQLException e) {
     System.out.println("Error deleting category: " + e.getMessage());
 }
}

//Delete Country
public void deleteCountry(int id) {
 String sql = "DELETE FROM Country WHERE id = ?";
 try (Connection conn = this.connect();
      PreparedStatement pstmt = conn.prepareStatement(sql)) {
     pstmt.setInt(1, id);
     pstmt.executeUpdate();
     System.out.println("Country deleted successfully.");
 } catch (SQLException e) {
     System.out.println("Error deleting country: " + e.getMessage());
 }
}

//Delete City
public void deleteCity(int id) {
 String sql = "DELETE FROM City WHERE id = ?";
 try (Connection conn = this.connect();
      PreparedStatement pstmt = conn.prepareStatement(sql)) {
     pstmt.setInt(1, id);
     pstmt.executeUpdate();
     System.out.println("City deleted successfully.");
 } catch (SQLException e) {
     System.out.println("Error deleting city: " + e.getMessage());
 }
}


}
