package Controller.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.DatabaseHandler;

public class ViewSellerIncome {
    static DatabaseHandler conn = new DatabaseHandler();

    public double CountSellerIncome(int seller_id) {

        String query = "SELECT SUM(e.harga) AS total_income FROM ticket t JOIN events e ON t.event_id = e.event_id JOIN seller s ON s.seller_id = e.seller_id WHERE s.seller_id = "
                + seller_id;
        double totalIncomeSeller = 0;
        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                totalIncomeSeller = rs.getInt("total_income");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }
        return totalIncomeSeller;
    }
}
