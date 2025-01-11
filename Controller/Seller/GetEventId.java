package Controller.Seller;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetEventId {
    static DatabaseHandler conn = new DatabaseHandler();

    public static int[] getEventIdsBySeller() {
        List<Integer> eventIds = new ArrayList<>();

        String query = "SELECT event_id FROM events WHERE seller_id = ?";

        try {
            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, LoginSingleton.getInstance().getID());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                eventIds.add(rs.getInt("event_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error fetching event IDs: " + e.getMessage());
        } finally {
            conn.disconnect();
        }

        return eventIds.stream().mapToInt(Integer::intValue).toArray();
    }
}
