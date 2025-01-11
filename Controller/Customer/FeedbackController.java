package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class FeedbackController {
    static DatabaseHandler conn = new DatabaseHandler();

    public boolean insertFeedback(String feedback, int event_id) {
        int cust_id = LoginSingleton.getInstance().getID();
    
        String query = "INSERT INTO feedback (FeedbackText, cust_id, event_id) VALUES (?, ?, ?)";
    
        try {
            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, feedback);
            stmt.setInt(2, cust_id);
            stmt.setInt(3, event_id);
    
            int result = stmt.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
