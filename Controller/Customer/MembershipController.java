package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;
import Models.Classess.Memberships;
import Models.Enumeration.Member;
import Models.Enumeration.Membership;

public class MembershipController implements Member {
    static DatabaseHandler conn = new DatabaseHandler();

    public boolean isMembershipActive() {
    int cust_id = LoginSingleton.getInstance().getID();
    try {
        conn.connect();

        String checkMembershipQuery = "SELECT Membership FROM customer WHERE cust_id = ?";
        PreparedStatement psCheck = conn.con.prepareStatement(checkMembershipQuery);
        psCheck.setInt(1, cust_id);
        ResultSet rs = psCheck.executeQuery();

        if (rs.next()) {
            String currentStatus = rs.getString("Membership");
            return "Active".equalsIgnoreCase(currentStatus);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conn.disconnect();
    }
    return false;
}


    public boolean activateMembership(Memberships memberships) {
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

                memberships.setStatus(Membership.ACTIVE);

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                conn.disconnect();
            }
        } else {
            return false;
        }
    }

    @Override
    public void update(String message) {
        System.out.println("MembershipController received update: " + message);
    }
}
