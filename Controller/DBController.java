package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBController {

    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean cekAdmin(String email, String password) {
        String query = "SELECT * FROM ADMIN WHERE email = ? AND password = ?";
        try {
            conn.connect();
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            return rs.next(); // Jika hasil ditemukan, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    public static boolean cekSeller(String email, String password) {
        String query = "SELECT * FROM SELLER WHERE email = ? AND password = ?";
        try {
            conn.connect();
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            return rs.next(); // Jika hasil ditemukan, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    public static boolean cekCustomer(String email, String password) {
        String query = "SELECT * FROM Customer WHERE email = ? AND password = ?";
        try {
            conn.connect();
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            return rs.next(); // Jika hasil ditemukan, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    public static boolean addUser(String role, String email, String password) {
        String query = "";
    
        if (role.equalsIgnoreCase("ADMIN")) {
            query = "INSERT INTO ADMIN (email, password) VALUES (?, ?)";
        } else if (role.equalsIgnoreCase("SELLER")) {
            query = "INSERT INTO SELLER (email, password) VALUES (?, ?)";
        } else if (role.equalsIgnoreCase("Customer")) {
            query = "INSERT INTO Customer (email, password) VALUES (?, ?)";
        } else {
            return false;
        }
    
        try {
            conn.connect();
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
    
            int rowsInserted = statement.executeUpdate(); // Jalankan query
            return rowsInserted > 0; // Jika ada baris yang ditambahkan, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }
    
}
