package Controller.Seller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Classess.Event;
import Controller.DatabaseHandler;
import Models.Classess.EventConcert;

public class GetEventData {
    public static void main(String[] args) {
        System.out.println(getData("2312"));
    }

    static DatabaseHandler conn = new DatabaseHandler();

    public static Event getData(String judul) {
        conn.connect();

        String query = "SELECT * FROM events WHERE judul = ?";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, judul); 
            ResultSet rs = statement.executeQuery();
            query = "";
            Event event = new EventConcert(
                rs.getInt("event_id"), 
                judul, 
                rs.getString("description"), 
                rs.getString("imagePath"), 
                rs.getDouble("harga"), 
                rs.getInt("capacity"), 
                rs.getDate("Date"),
                rs.getString("Genre"), 
                rs.getString("Singer")
            );

            return event;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conn.disconnect();
        }
    }
}
