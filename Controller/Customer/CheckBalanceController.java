package Controller.Customer;

import java.sql.ResultSet;
import java.sql.Statement;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class CheckBalanceController {

    static DatabaseHandler conn = new DatabaseHandler();

    public double getBalance() {
        double balance = 0.0;

        int custId = LoginSingleton.getInstance().getID();


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

    public String getName () {
        String name = " ";
        
        int custId = LoginSingleton.getInstance().getID();

        String query = "SELECT cust_name FROM customer WHERE cust_id = " + custId;

        ResultSet result = null;
        
        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            result = stmt.executeQuery(query);

            if (result.next()) {
                name = result.getString("cust_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
}
