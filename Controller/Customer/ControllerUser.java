package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class ControllerUser {
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

    public String getPassword () {
        String password = " ";
        
        int custId = LoginSingleton.getInstance().getID();

        String query = "SELECT password FROM customer WHERE cust_id = " + custId;

        ResultSet result = null;
        
        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            result = stmt.executeQuery(query);

            if (result.next()) {
                password = result.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public String getNoTlp () {
        String noTlp = " ";
        
        int custId = LoginSingleton.getInstance().getID();

        String query = "SELECT phoneNum FROM customer WHERE cust_id = " + custId;

        ResultSet result = null;
        
        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            result = stmt.executeQuery(query);

            if (result.next()) {
                noTlp = result.getString("phoneNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noTlp;
    }

    public String getEmail () {
        String email = " ";
        
        int custId = LoginSingleton.getInstance().getID();

        String query = "SELECT email FROM customer WHERE cust_id = " + custId;

        ResultSet result = null;
        
        try {
            conn.connect();
            Statement stmt = conn.con.createStatement();
            result = stmt.executeQuery(query);

            if (result.next()) {
                email = result.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }


    public void setBalance(double newBalance) {
        int custId = LoginSingleton.getInstance().getID();
        String query = "UPDATE customer SET balance = ? WHERE cust_id = ?";

        try {
            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, custId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Balance updated successfully for cust_id: " + custId);
            }
        } catch (SQLException e) {
            System.err.println("Error updating balance: " + e.getMessage());
        }
    }
}
