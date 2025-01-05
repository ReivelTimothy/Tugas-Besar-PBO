package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerCart {

    static DatabaseHandler conn = new DatabaseHandler();

    public double getTotalAmount() {
        double totalAmount = 0;

        try {
            String query = "SELECT SUM(e.harga * COUNT(c.card_id)) AS Amount "
                         + "FROM cart c "
                         + "JOIN events e ON c.event_id = e.event_id "
                         + "GROUP BY c.event_id";
            PreparedStatement statement = conn.con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalAmount = resultSet.getDouble("total");
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalAmount;
    }

    public boolean processTransaction(double payment) {
        double totalAmount = getTotalAmount();

        if (payment >= totalAmount) {

            try {
                String query = "DELETE FROM Cart";
                PreparedStatement statement = conn.con.prepareStatement(query);
                statement.executeUpdate();
                statement.close();

                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
