package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewCartController {

    public static void displayCart(JTable cartTable) {
        List<Object[]> cartData = getCartData();

        if (cartData == null || cartData.isEmpty()) {
            String[] columnNames = {"Cart ID", "Event ID", "Ticket ID", "Customer ID"};
            cartTable.setModel(new DefaultTableModel(new Object[0][4], columnNames));
            return;
        }

        String[] columnNames = {"Cart ID", "Event ID", "Ticket ID", "Customer ID"};
        Object[][] data = new Object[cartData.size()][4];

        for (int i = 0; i < cartData.size(); i++) {
            data[i] = cartData.get(i);
        }

        cartTable.setModel(new DefaultTableModel(data, columnNames));
    }

    public static List<Object[]> getCartData() {
        DatabaseHandler conn = new DatabaseHandler();
        List<Object[]> cartData = new ArrayList<>();

        int cust_id = LoginSingleton.getInstance().getID();
        String query = "SELECT * FROM cart WHERE cust_id = ?";

        try {
            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setInt(1, cust_id);

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Object[] row = new Object[4];
                    row[0] = resultSet.getInt("cart_id");
                    row[1] = resultSet.getInt("event_id");
                    row[2] = resultSet.getInt("ticket_id");
                    row[3] = resultSet.getInt("cust_id");
                    cartData.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartData;
    }
}
