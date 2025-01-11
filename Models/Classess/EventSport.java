package Models.Classess;

import java.sql.Date;

import Models.Enumeration.EventCat;

public class EventSport extends Event {
    private String jenisSport;

    public EventSport(int eventId, String title, String desc, String path,
            double price, int capacity, Date tanggal, String jenisSport, Double income) {
        super(eventId, title, desc, path, price, capacity, tanggal, EventCat.SPORT, income);
        this.jenisSport = jenisSport;
    }
    public EventSport(int eventId, String title, String desc, String path,
            double price, int capacity, Date tanggal, String jenisSport) {
        super(eventId, title, desc, path, price, capacity, tanggal, EventCat.SPORT,0);
        this.jenisSport = jenisSport;
    }

    public String getJenisSport() {
        return jenisSport;
    }

    public void setJenisSport(String jenisSport) {
        this.jenisSport = jenisSport;
    }

}
