package Models.Classess;

import java.sql.Date;

public class EventSport extends Event {
    private String jenisSport;

    public EventSport(int eventId, String title, String location, String snk, String vendor, String desc,String path,
            double price,  int capacity, Date tanggal, String jenisSport) {
        super(eventId, title, location, snk, vendor, desc, path, price, capacity, tanggal);
        this.jenisSport = jenisSport;
    }

    public String getJenisSport() {
        return jenisSport;
    }

    public void setJenisSport(String jenisSport) {
        this.jenisSport = jenisSport;
    }

}
