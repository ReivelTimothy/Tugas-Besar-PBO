package Controller.Seller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;
import Models.Classess.Event;
import Models.Classess.EventConcert;
import Models.Classess.EventEducation;
import Models.Classess.EventSport;
import Models.Enumeration.EventCat;

public class GetEventWithIncome {
    static DatabaseHandler conn = new DatabaseHandler();

    public static Event getEventBySeller(int eventId) {
        Event event = null;

        String query = "SELECT e.*, " +
                       "(SELECT COALESCE(SUM(t.ticket_id * e.harga), 0) " +
                       "FROM ticket t WHERE t.event_id = e.event_id) AS income " +
                       "FROM events e WHERE e.seller_id = ? AND e.event_id = ? ORDER BY e.Date DESC";

        try {
            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, LoginSingleton.getInstance().getID());
            stmt.setInt(2, eventId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String title = rs.getString("judul");
                String desc = rs.getString("description");
                double price = rs.getDouble("harga");
                int capacity = rs.getInt("capacity");
                java.sql.Date date = rs.getDate("Date");
                String path = rs.getString("imagePath");
                String category = rs.getString("kategori");
                double income = rs.getDouble("income");

                // Parsing kategori sebagai enum dan membuat instance Event yang sesuai
                EventCat eventCat = EventCat.valueOf(category.toUpperCase());
                switch (eventCat) {
                    case MUSIC:
                        String singer = rs.getString("Singer");
                        String genre = rs.getString("Genre");
                        event = new EventConcert(eventId, title, desc, path, price, capacity, date, genre, singer, income);
                        break;
                    case EDUCATION:
                        String speaker = rs.getString("Speaker");
                        event = new EventEducation(eventId, title, desc, path, price, capacity, date, speaker, income);
                        break;
                    case SPORT:
                        String sportType = rs.getString("SportType");
                        event = new EventSport(eventId, title, desc, path, price, capacity, date, sportType, income);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown category: " + category);
                }
            } else {
                System.err.println("No event found for event_id: " + eventId);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid category in database: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Error fetching event: " + e.getMessage());
        } finally {
            conn.disconnect();
        }

        return event;
    }
}
