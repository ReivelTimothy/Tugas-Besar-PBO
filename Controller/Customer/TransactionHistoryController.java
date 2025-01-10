package Controller.Customer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class TransactionHistoryController {
    static DatabaseHandler conn = new DatabaseHandler();

    public static void displayMembership(JTable table) {
        int custId = LoginSingleton.getInstance().getID();

        String[] columnNames = {"Ticket ID", "Ticket Description", "Customer ID", "Event ID", "Time of Purchase"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        try {
            conn.connect();
            String query = "SELECT ticket_id, ticket_desc, cust_id, event_id, timeBuy FROM ticket WHERE cust_id = ?";
            PreparedStatement preparedStatement = conn.con.prepareStatement(query);
            preparedStatement.setInt(1, custId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int ticketID = resultSet.getInt("ticket_id");
                    String ticketDesc = resultSet.getString("ticket_desc");
                    int custID = resultSet.getInt("cust_id");
                    int eventID = resultSet.getInt("event_id");
                    Date timeBuy = resultSet.getDate("timeBuy");

                    tableModel.addRow(new Object[]{ticketID, ticketDesc, custID, eventID, timeBuy});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setModel(tableModel);
    }
}
