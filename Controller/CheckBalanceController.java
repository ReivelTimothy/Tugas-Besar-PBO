package Controller;

import java.sql.ResultSet;
import java.sql.Statement;

import Models.Classess.User;

public class CheckBalanceController {

    static DatabaseHandler conn = new DatabaseHandler();

    public double getBalance() {
        double balance = 0.0;

        LoginCheck loginCheck = LoginCheck.getInstance();
        User user = loginCheck.getUserLogin();

        int custId = user.getUserId();

        String query = "SELECT balance FROM customer WHERE cust_id = " + custId;
        
        ResultSet resultSet = null;

        try {
            conn.connect();
            Statement statement = conn.con.createStatement();
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }
}
