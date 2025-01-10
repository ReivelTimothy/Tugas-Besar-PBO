package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class StatusMembershipController {

    static DatabaseHandler conn = new DatabaseHandler();

    public static void displayMembership(JTable statusTable) {
        String query = "SELECT cust_id, Membership FROM customer WHERE cust_id = ?";
        int userId = LoginSingleton.getInstance().getID();
        try {
            conn.connect();

            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            String[] columnNames = {"User ID", "Membership Status"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            while (resultSet.next()) {
                int id = resultSet.getInt("cust_id");
                String membershipStatus = resultSet.getString("Membership");

                model.addRow(new Object[]{id, membershipStatus});
            }

            statusTable.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
}
