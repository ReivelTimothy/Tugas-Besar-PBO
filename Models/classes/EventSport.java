package models.classes;

import java.sql.Date;

public abstract class EventSport extends Eventt{
    String jenisSport;

    public EventSport(String title, String location, String snk, String vendor, String dateTime, String information,
            double price, double discount, int rating, String jenisSport, Date tanggal) {
        super(title, location, snk, vendor, dateTime, information, price, discount, rating, tanggal);
        this.jenisSport = jenisSport;
    }

    public String getJenisSport() {
        return jenisSport;
    }

    public void setJenisSport(String jenisSport) {
        this.jenisSport = jenisSport;
    }
    
}
