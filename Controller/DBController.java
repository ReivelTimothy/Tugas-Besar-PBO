package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.classes.EventConcert;
import models.enumaration.EventCat;

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

    public static boolean addConcert(EventConcert event){
        String query = 
        "INSERT INTO events (event_id, judul, harga, eventStart, eventEnd, description, kategori, capacity, date, seller_id) " +
        " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn.connect();
            java.sql.Date sqlDate = new java.sql.Date((event.getTanggal()).getTime());
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, event.getTitle());
            stmt.setDouble(3, event.getPrice());
            stmt.setString(4, event.getTimeStart());
            stmt.setString(5, event.getTimeEnd());
            stmt.setString(6, event.getDesc());
            stmt.setString(7, EventCat.getEnum(EventCat.MUSIC));
            stmt.setInt(8, event.getCapacity());
            stmt.setDate(9, sqlDate);
            stmt.setInt(10, 0);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "EVENT ANDA TELAH TERDAFTAR ");

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public static boolean addUser(String role, String email, String password) {
        String query = "";
    
        if (role.equalsIgnoreCase("SELLER")) {
            query = "INSERT INTO seller (email, password) VALUES (?, ?)";
        } else if (role.equalsIgnoreCase("Customer")) {
            query = "INSERT INTO customer (email, password) VALUES (?, ?)";
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
