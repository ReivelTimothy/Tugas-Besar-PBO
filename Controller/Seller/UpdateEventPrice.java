package Controller.Seller;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UpdateEventPrice {
    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean updateEventPrice(int eventId, double newPrice) {
        boolean isUpdated = false;

        // Query untuk memeriksa apakah event dimiliki oleh seller
        String checkQuery = "SELECT COUNT(*) AS count FROM events WHERE event_id = ? AND seller_id = ?";

        // Query untuk memperbarui harga event
        String updateQuery = "UPDATE events SET harga = ? WHERE event_id = ? AND seller_id = ?";

        try {
            conn.connect();

            // Mengecek apakah event dimiliki oleh seller
            PreparedStatement checkStmt = conn.con.prepareStatement(checkQuery);
            checkStmt.setInt(1, eventId);
            checkStmt.setInt(2, LoginSingleton.getInstance().getID());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt("count") > 0) {
                PreparedStatement updateStmt = conn.con.prepareStatement(updateQuery);
                updateStmt.setDouble(1, newPrice);
                updateStmt.setInt(2, eventId);
                updateStmt.setInt(3, LoginSingleton.getInstance().getID());

                int rowsAffected = updateStmt.executeUpdate();
                if (rowsAffected > 0) {
                    isUpdated = true;
                    JOptionPane.showMessageDialog(null, "Event Berhasil Di Update");
                } else {
                    JOptionPane.showMessageDialog(null, "Event Gagal Di Update");
                }
            } else {
                
                JOptionPane.showMessageDialog(null, "Event ini Bukan Milik Kamu");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating event price: " + e.getMessage());
        } finally {
            conn.disconnect();
        }

        return isUpdated;
    }
}
