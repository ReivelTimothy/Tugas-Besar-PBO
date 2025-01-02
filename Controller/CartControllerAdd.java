package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartControllerAdd {
    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean addToCart(String eventId, String ticketId, String customerId) {
        String query = "INSERT INTO cart (event_id, ticket_id, cust_id) VALUES (?, ?, ?)";

        try {
            conn.connect();

            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, eventId);
            statement.setString(2, ticketId);
            statement.setString(3, customerId);

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }
}
