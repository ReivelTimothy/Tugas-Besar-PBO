package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CreateEvent {
    static DatabaseHandler conn = new DatabaseHandler();

    public static void EventCreate(String eventName,  String eventStart, String eventEnd, String Description, String kategori, String capacity, String price) {

        try {
            conn.connect();
            String query = "INSERT INTO events (event_id, judul, harga, eventStart, eventEnd, description, kategori, capacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, eventName);
            stmt.setString(3, eventStart);
            stmt.setString(4, eventEnd);
            stmt.setString(5, Description);
            stmt.setString(6, kategori);
            stmt.setString(7, capacity);
            stmt.setString(8, price);

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
