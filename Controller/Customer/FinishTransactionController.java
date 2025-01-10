package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class FinishTransactionController {

    static DatabaseHandler conn = new DatabaseHandler();

    public Object[][] getCartItems() {
        int custId = LoginSingleton.getInstance().getID();
        try {
            conn.connect();
            String query = """
                        SELECT c.cart_id, e.judul AS event_name, e.harga, COUNT(c.ticket_id) AS quantity, (e.harga * COUNT(c.ticket_id)) AS total_price
                        FROM cart c
                        JOIN events e ON c.event_id = e.event_id
                        WHERE c.cust_id = ?
                        GROUP BY c.cart_id, e.judul, e.harga
                         """;
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, custId);
            ResultSet resultSet = statement.executeQuery();

            List<Object[]> cartData = new ArrayList<>();

            while (resultSet.next()) {
                int cartId = resultSet.getInt("cart_id");
                String eventName = resultSet.getString("event_name");
                double price = resultSet.getDouble("harga");
                int quantity = resultSet.getInt("quantity");
                double totalPrice = resultSet.getDouble("total_price");

                cartData.add(new Object[]{false, cartId, eventName, price, quantity, totalPrice});
            }
            resultSet.close();
            statement.close();

            return cartData.toArray(new Object[0][]);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public double calculateTotalAmount(List<Integer> selectedCartIds) {
        double totalAmount = 0;
        try {
            conn.connect();
            for (int cartId : selectedCartIds) {
                String query = """
                            SELECT e.harga, COUNT(c.ticket_id) AS quantity, SUM(e.harga) AS total_price
                            FROM cart c
                            JOIN events e ON c.event_id = e.event_id
                            WHERE c.cart_id = ?
                            """;
                PreparedStatement statement = conn.con.prepareStatement(query);
                statement.setInt(1, cartId);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    totalAmount += resultSet.getDouble("total_price");
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalAmount;
    }

    public boolean processTransaction(List<Integer> selectedCartIds, double currentBalance) {
        double totalAmount = calculateTotalAmount(selectedCartIds);

        int custId = LoginSingleton.getInstance().getID();
    
        if (currentBalance >= totalAmount) {
            try {
                conn.connect();
                for (int cartId : selectedCartIds) {
                    String query = "DELETE FROM cart WHERE cart_id = ? AND cust_id = ?";
                    PreparedStatement statement = conn.con.prepareStatement(query);
                    statement.setInt(1, cartId);
                    statement.setInt(2, custId);
                    statement.executeUpdate();
                    statement.close();
                }
    
                boolean balanceUpdated = updateUserBalance(totalAmount);
    
                return balanceUpdated;
    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        return false;
    }
    

    public boolean updateUserBalance(double totalAmount) {

        int custId = LoginSingleton.getInstance().getID();
        try {
            conn.connect();
            String query = "UPDATE customer SET balance = balance - ? WHERE cust_id = ?";
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setDouble(1, totalAmount);
            statement.setInt(2, custId);
            int rowsAffected = statement.executeUpdate();
            statement.close();
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
