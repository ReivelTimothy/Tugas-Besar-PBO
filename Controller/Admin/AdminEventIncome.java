package Controller.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.DatabaseHandler;

public class AdminEventIncome {
    static DatabaseHandler conn = new DatabaseHandler();

    // biaya admin 1000
    public double AllEventAdminIncome() {
        double totalIncome = 0;

        try {
            conn.connect();
            String query = "SELECT SUM(e.harga) AS total_income FROM ticket t JOIN events e ON t.event_id = e.event_id GROUP BY e.judul";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                totalIncome += rs.getInt("total_income");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }
        return totalIncome * 0.1;
    }

    public double IncomeAdminPerEvent(int event_id) {
        String query = "SELECT SUM(e.harga) AS total_income FROM ticket t JOIN events e ON t.event_id = e.event_id WHERE e.event_id = ?";
        double incomeAdmin = 0;
        try {
            conn.connect();
            PreparedStatement stmtQuery = conn.con.prepareStatement(query);
    
            stmtQuery.setInt(1, event_id);
            ResultSet rs = stmtQuery.executeQuery();
    
            if (rs.next()) {
                incomeAdmin = rs.getDouble("total_income");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return incomeAdmin * 0.1;
    }
    
}
