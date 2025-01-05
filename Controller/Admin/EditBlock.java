package Controller.Admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Models.Enumeration.statusBlocked;

public class EditBlock {
    static DatabaseHandler conn = new DatabaseHandler();

    // public EditBlock(int userID, statusBlocked status, int role) {
    // Edit(userID, status, role);
    // }

    public void Unblock(int userID, int role) {

        String updatedRole = getUserRole(role);
        String queryUnblock = "DELETE FROM block WHERE " + updatedRole + " = ?";

        String queryUpdateTable = "";

        if (updatedRole.equals("cust_id")) {
            queryUpdateTable = "UPDATE customer SET block = 'Unblock' WHERE cust_id = ?";
        } else {
            queryUpdateTable = "UPDATE seller SET block = 'Unblock' WHERE seller_id = ?";
        }
        try {
            conn.connect();
            PreparedStatement stmtUnblock = conn.con.prepareStatement(queryUnblock);
            PreparedStatement stmtUpdateUser = conn.con.prepareStatement(queryUpdateTable);

            stmtUnblock.setInt(1, userID);
            stmtUpdateUser.setInt(1, userID);

            stmtUnblock.executeUpdate();
            stmtUpdateUser.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }
    }

    public void Block(int userID, String reason, int role) {

        String updatedRole = getUserRole(role);
        String queryBlock = "";
        String queryUpdateTable = "";

        if (updatedRole.equals("cust_id")) {
            queryBlock = "INSERT INTO block (block_Reason, cust_id) VALUES (?,?)";
            queryUpdateTable = "UPDATE customer SET block = 'Blocked' WHERE cust_id IN (?)";
        } else {
            queryBlock = "INSERT INTO block (block_Reason, seller_id) VALUES (?,?)";
            queryUpdateTable = "UPDATE seller SET block = 'Blocked' WHERE seller_id IN (?)";
        }

        try {
            conn.connect();
            PreparedStatement stmtBlock = conn.con.prepareStatement(queryBlock);
            PreparedStatement stmtUpdateUser = conn.con.prepareStatement(queryUpdateTable);

            stmtBlock.setString(1, reason);
            stmtBlock.setInt(2, userID);

            stmtUpdateUser.setInt(1, userID);

            stmtBlock.executeUpdate();
            stmtUpdateUser.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }
    }

    public String getUserRole(int role) {

        if (role == 0) {
            return "cust_id";
        }
        return "seller_id";
    }
}
