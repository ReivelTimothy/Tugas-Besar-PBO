package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

import Models.Enumeration.RefundStatus;

public class getRefundData {
    static DatabaseHandler conn = new DatabaseHandler();
    int eventID = 0;
    int cust_id = 0;
    RefundStatus status;

    public int getIDEvent(String eventName) {
        cust_id = LoginSingleton.getInstance().getID();
        String query = "SELECT t.event_id FROM ticket t JOIN events e ON e.event_id = t.event_id WHERE t.cust_id = ? AND e.judul LIKE ?";

        try {
            conn.connect();
            PreparedStatement stmtQuery = conn.con.prepareStatement(query);

            stmtQuery.setInt(1, cust_id);
            stmtQuery.setString(2, "%" + eventName + "%");
            ResultSet rs = stmtQuery.executeQuery();

            if (rs.next()) {
                eventID = rs.getInt("event_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return eventID;
    }

    public boolean requestRefund(String eventName) {

        cust_id = LoginSingleton.getInstance().getID();
        int event_id = getIDEvent(eventName);
        int amount = 0;
        String queryInsert = "INSERT INTO refund (event_id,cust_id,amount,status_refund) VALUES (?,?,?,?)";

        String queryAmount = "SELECT harga FROM events WHERE event_id = " + event_id;

        try {
            conn.connect();
            PreparedStatement stmtInsert = conn.con.prepareStatement(queryInsert);

            PreparedStatement stmtAmount = conn.con.prepareStatement(queryAmount);

            ResultSet rs = stmtAmount.executeQuery();

            if (rs.next()) {
                amount = rs.getInt("harga");
            }

            stmtInsert.setInt(1, event_id);
            stmtInsert.setInt(2, cust_id);
            stmtInsert.setInt(3, amount);
            stmtInsert.setString(4, RefundStatus.PENDING.name());

            stmtInsert.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

}
