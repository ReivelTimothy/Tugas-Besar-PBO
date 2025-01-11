package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class MembershipController {

    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean activateMembership() {
        int cust_id = LoginSingleton.getInstance().getID();
        ControllerUser controller = new ControllerUser();
        double balance = controller.getBalance();

        double membershipCost = 50000;

        if (balance >= membershipCost) {
            try {
                conn.connect();

                String updateBalanceQuery = "UPDATE customer SET balance = balance - ? WHERE cust_id = ?";
                PreparedStatement psBalance = conn.con.prepareStatement(updateBalanceQuery);
                psBalance.setDouble(1, membershipCost);
                psBalance.setInt(2, cust_id);
                psBalance.executeUpdate();

                String activateMembershipQuery = "UPDATE customer SET Membership = 'Active' WHERE cust_id = ?";
                PreparedStatement psMembership = conn.con.prepareStatement(activateMembershipQuery);
                psMembership.setInt(1, cust_id);
                psMembership.executeUpdate();

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
