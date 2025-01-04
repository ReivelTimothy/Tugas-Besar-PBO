package Controller.Admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.DatabaseHandler;

public class EditEventPrice {
    static DatabaseHandler conn = new DatabaseHandler();

    public EditEventPrice(int eventID, double price) {
        EditPrice(eventID, price);
    }

    public void EditPrice(int id, double price) {
        String queryEditPrice = "UPDATE events SET harga = ? WHERE event_id = ? ";

        try {
            conn.connect();
            PreparedStatement stmtEditPrice = conn.con.prepareStatement(queryEditPrice);
           
            stmtEditPrice.setDouble(1, price);
            stmtEditPrice.setDouble(2, id);
            
            stmtEditPrice.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }
    }
}
