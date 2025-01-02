package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditedCart {
    static DatabaseHandler conn = new DatabaseHandler();

    public EditedCart() {
        int userID = LoginSingleton.getInstance().getID();
        System.out.println(userID);
        System.out.println(LoginSingleton.getInstance().getRole());
    }

    public static boolean editCart(String cartId, String eventId, String ticketId, String customerId) {
        String query = "UPDATE cart SET event_id = ?, ticket_id = ?, cust_id = ? WHERE cart_id = ?";

        try {
            conn.connect();

            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, eventId);
            statement.setString(2, ticketId);
            statement.setString(3, customerId);
            statement.setString(4, cartId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }
}
