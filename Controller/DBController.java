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

    // public static boolean insertNewUser(User user) {
    //     String query = "INSERT INTO  ";
    //     try {
    //         conn.connect();
    //         PreparedStatement statement = conn.con.prepareStatement(query);
           

    //         statement.executeUpdate();
    //         return true;
    //     }
    //     catch (SQLException e) {
    //         e.printStackTrace();
    //         return false;
    //     }
    //     finally {
    //         conn.disconnect();
    //     }
    // }

    // public static boolean deleteData() {
    //     String query = "DELETE FROM  WHERE ";
    //     try {
    //         conn.connect();
    //         PreparedStatement statement = conn.con.prepareStatement(query);
    //         // statement.setString(1, );
    //         int rowsDeleted = statement.executeUpdate();
    //         return rowsDeleted > 0;
    //     }
    //     catch (SQLException e) {
    //         e.printStackTrace();
    //         return false;
    //     }
    //     finally {
    //         conn.disconnect();
    //     }
    // }
}
