package Controller.Admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Models.Enumeration.RefundStatus;

public class RefundTicketUser {
    static DatabaseHandler conn = new DatabaseHandler();

    public void Refund(int userID, int eventID, RefundStatus status) {
        String queryStatus = "";
        String queryBalance = "";
        String queryDeleteTicket = "";

        if (status == RefundStatus.APPROVED) {
            queryStatus = "UPDATE refund SET status_refund = '" + RefundStatus.APPROVED
                    + "' WHERE event_id = ? AND cust_id = ?";
            queryBalance = "UPDATE customer SET balance = balance + (SELECT amount FROM refund WHERE event_id = ? AND cust_id = ?) WHERE cust_id = ?";
            queryDeleteTicket = "DELETE FROM ticket where event_id = ? AND cust_id = ?";

            
        try {
            conn.connect();
            PreparedStatement stmtStatus = conn.con.prepareStatement(queryStatus);
            PreparedStatement stmtBalance = conn.con.prepareStatement(queryBalance);
            PreparedStatement stmtDeleteTicket = conn.con.prepareStatement(queryDeleteTicket);

            stmtStatus.setInt(1, eventID);
            stmtStatus.setInt(2, userID);

            stmtBalance.setInt(1, eventID);
            stmtBalance.setInt(2, userID);
            stmtBalance.setInt(3, userID);

            stmtDeleteTicket.setInt(1, eventID);
            stmtDeleteTicket.setInt(2, userID);

            stmtStatus.executeUpdate();
            stmtBalance.executeUpdate();
            stmtDeleteTicket.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }

        } else if (status == RefundStatus.REJECTED){
            queryStatus = "UPDATE refund SET status_refund = '" + RefundStatus.REJECTED
                    +"' WHERE event_id = ? AND cust_id = ?";
                    
        try {
            conn.connect();
            PreparedStatement stmtStatus = conn.con.prepareStatement(queryStatus);
           
            stmtStatus.setInt(1, eventID);
            stmtStatus.setInt(2, userID);
            stmtStatus.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }
        }

    }
}
