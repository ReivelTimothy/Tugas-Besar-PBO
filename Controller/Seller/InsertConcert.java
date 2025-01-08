package Controller.Seller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JOptionPane;

import Controller.DatabaseHandler;
import Models.Classess.EventConcert;
import Models.Classess.EventEducation;
import Models.Classess.EventSport;
import Models.Enumeration.*;

public class InsertConcert {
    static DatabaseHandler conn = new DatabaseHandler();

    public static void InsertConcertEvent(EventConcert eventConcert, int sellerId, String path) {

        try {
            conn.connect();
            String query = "INSERT INTO events (judul, singer, Genre, harga, description, kategori, capacity, Date, imagePath, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            java.sql.Date sqlDate = new java.sql.Date(eventConcert.getTanggal().getTime());     
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, eventConcert.getTitle());
            stmt.setString(2, eventConcert.getSinger());
            stmt.setString(3, eventConcert.getJenisKonser());
            stmt.setDouble(4, eventConcert.getPrice());
            stmt.setString(5, eventConcert.getDesc());
            stmt.setString(6, EventCat.MUSIC.name());
            stmt.setInt(7, eventConcert.getCapacity());
            stmt.setDate(8, sqlDate);
            stmt.setString(9, path);
            stmt.setInt(10, sellerId);


            int rows = stmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Event successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to create event.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }
    }
    public static void InsertEduEvent(EventEducation eventEducation, int sellerId) {

        try {
            conn.connect();
            String query = "INSERT INTO events (judul, speaker,  harga, eventStart, eventEnd, description, kategori, capacity, Date, seller_id) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            java.sql.Date sqlDate = new java.sql.Date(eventEducation.getTanggal().getTime());     
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, eventEducation.getTitle());
            stmt.setString(2, eventEducation.getNamaPembicara());
            stmt.setDouble(3, eventEducation.getPrice());
            stmt.setString(6, eventEducation.getDesc());
            stmt.setString(7, EventCat.EDUCATION.name());
            stmt.setInt(8, eventEducation.getCapacity());
            stmt.setDate(9, sqlDate);
            stmt.setInt(10, sellerId);


            int rows = stmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Event successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to create event.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }
    }
    public static void InsertSportEvent(EventSport eventSport, int sellerId) {

        try {
            conn.connect();
            String query = "INSERT INTO events (judul, SportType, harga, eventStart, eventEnd, description, kategori, capacity, Date, seller_id) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            java.sql.Date sqlDate = new java.sql.Date(eventSport.getTanggal().getTime());     
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, eventSport.getTitle());
            stmt.setString(2, eventSport.getJenisSport());
            stmt.setDouble(3, eventSport.getPrice());
            stmt.setString(6, eventSport.getDesc());
            stmt.setString(7, EventCat.SPORT.name());
            stmt.setInt(8, eventSport.getCapacity());
            stmt.setDate(9, sqlDate);
            stmt.setInt(10, sellerId);


            int rows = stmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Event successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to create event.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }
    }
}