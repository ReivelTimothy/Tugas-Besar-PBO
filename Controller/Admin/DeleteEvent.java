package Controller.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.DatabaseHandler;

public class DeleteEvent {
    static DatabaseHandler conn = new DatabaseHandler();

    public DeleteEvent(int eventID) {
        Delete(eventID);
    }

    public void Delete(int eventId) {
        System.out.println();
        String queryDeleteEvent = "DELETE FROM events WHERE event_id = ? ";
        String queryDeleteTicket = "DELETE FROM ticket WHERE event_id = ? ";
        
        System.out.println(queryDeleteEvent);
        try {
            conn.connect();
            PreparedStatement stmtDeleteEvent = conn.con.prepareStatement(queryDeleteEvent);
            PreparedStatement stmtDeleteTicket = conn.con.prepareStatement(queryDeleteTicket);

            stmtDeleteEvent.setInt(1, eventId);
            stmtDeleteTicket.setInt(1, eventId);

            stmtDeleteTicket.executeUpdate();
            stmtDeleteEvent.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }
    }
}
