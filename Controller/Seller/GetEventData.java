package Controller.Seller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Classess.Event;
import Controller.DatabaseHandler;
import Models.Classess.EventConcert;
import Models.Classess.EventEducation;
import Models.Classess.EventSport;
import Models.Enumeration.EventCat;

public class GetEventData {
    public static void main(String[] args) {
        Event event = getData("assets\\2.png");
        System.out.println(event.getTitle());
    }

    static DatabaseHandler conn = new DatabaseHandler();

    public static Event getData(String path) {
        conn.connect();

        String query = "SELECT * FROM events WHERE imagePath = ?";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, path);
            ResultSet rs = statement.executeQuery();
            Event event;
            if (rs.next()) { // Pastikan ada data yang dikembalikan
                if (rs.getString("kategori").equalsIgnoreCase(EventCat.MUSIC.name())) {
                    event = new EventConcert(
                            rs.getInt("event_id"),
                            rs.getString("Judul"),
                            rs.getString("description"),
                            rs.getString("imagePath"),
                            rs.getDouble("harga"),
                            rs.getInt("capacity"),
                            rs.getDate("Date"),
                            rs.getString("Genre"),
                            rs.getString("Singer"));
                } else if (rs.getString("kategori").equalsIgnoreCase(EventCat.EDUCATION.name())) {
                    event = new EventEducation(
                            rs.getInt("event_id"),
                            rs.getString("Judul"),
                            rs.getString("description"),
                            rs.getString("imagePath"),
                            rs.getDouble("harga"),
                            rs.getInt("capacity"),
                            rs.getDate("Date"),
                            rs.getString("Speaker"));
                } else { // sport
                    event = new EventSport(
                            rs.getInt("event_id"),
                            rs.getString("Judul"),
                            rs.getString("description"),
                            rs.getString("imagePath"),
                            rs.getDouble("harga"),
                            rs.getInt("capacity"),
                            rs.getDate("Date"),
                            rs.getString("SportType"));
                }
                return event;
            } else {
                System.err.println("No event found with the given image path: " + path);
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conn.disconnect();
        }
    }
}
