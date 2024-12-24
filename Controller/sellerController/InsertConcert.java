package controller.sellerController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import controller.DatabaseHandler;
import models.classes.EventConcert;
import models.classes.EventEducation;
import models.classes.EventSport;
import models.enumaration.EventCat;

public class InsertConcert {
    static DatabaseHandler conn = new DatabaseHandler();

    public static void InsertConcertEvent(EventConcert eventConcert, int sellerId) {

        try {
            conn.connect();
            String query = "INSERT INTO events (judul, singer, ConcertType, harga, eventStart, eventEnd, description, kategori, capacity, Date, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            // java.sql.Date sqlDate = new java.sql.Date(eventConcert.getTanggal().getTime());     
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, eventConcert.getTitle());
            stmt.setString(2, eventConcert.getSinger());
            stmt.setString(3, eventConcert.getJenisKonser());
            stmt.setDouble(4, eventConcert.getPrice());
            stmt.setString(5, eventConcert.getTimeStart());
            stmt.setString(6, eventConcert.getTimeEnd());
            stmt.setString(7, eventConcert.getDesc());
            stmt.setString(8, EventCat.MUSIC.name());
            stmt.setInt(9, eventConcert.getCapacity());
            stmt.setDate(10, eventConcert.getTanggal());
            stmt.setInt(11, sellerId);


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
            
            
            // java.sql.Date sqlDate = new java.sql.Date(eventConcert.getTanggal().getTime());     
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, eventEducation.getTitle());
            stmt.setString(2, eventEducation.getNamaPembicara());
            stmt.setDouble(3, eventEducation.getPrice());
            stmt.setString(4, eventEducation.getTimeStart());
            stmt.setString(5, eventEducation.getTimeEnd());
            stmt.setString(6, eventEducation.getDesc());
            stmt.setString(7, EventCat.EDUCATION.name());
            stmt.setInt(8, eventEducation.getCapacity());
            stmt.setDate(9, eventEducation.getTanggal());
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
            
            
            // java.sql.Date sqlDate = new java.sql.Date(eventConcert.getTanggal().getTime());     
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, eventSport.getTitle());
            stmt.setString(2, eventSport.getJenisSport());
            stmt.setDouble(3, eventSport.getPrice());
            stmt.setString(4, eventSport.getTimeStart());
            stmt.setString(5, eventSport.getTimeEnd());
            stmt.setString(6, eventSport.getDesc());
            stmt.setString(7, EventCat.SPORT.name());
            stmt.setInt(8, eventSport.getCapacity());
            stmt.setDate(9, eventSport.getTanggal());
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