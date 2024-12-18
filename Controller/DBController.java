package Controller;

public class DBController {

    static DatabaseHandler conn = new DatabaseHandler();

    // public static boolean addUser(String role, String email, String password) {
    //     String query = "";
    
    //     if (role.equalsIgnoreCase("SELLER")) {
    //         query = "INSERT INTO SELLER (email, password) VALUES (?, ?)";
    //     } else if (role.equalsIgnoreCase("Customer")) {
    //         query = "INSERT INTO Customer (email, password) VALUES (?, ?)";
    //     } else {
    //         return false;
    //     }
    
    //     try {
    //         conn.connect();
    //         PreparedStatement statement = conn.con.prepareStatement(query);
    //         statement.setString(1, email);
    //         statement.setString(2, password);
    
    //         int rowsInserted = statement.executeUpdate(); // Jalankan query
    //         return rowsInserted > 0; // Jika ada baris yang ditambahkan, return true
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return false;
    //     } finally {
    //         conn.disconnect();
    //     }
    // }
    
}
