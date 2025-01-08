package Models.Classess;

import java.sql.Date;

public class EventEducation extends Event {
    String namaPembicara;

    public EventEducation(int eventId, String title, String location, String snk, String vendor,
            String desc, String path, double price, int capacity, Date tanggal,
            String namaPembicara) {
        super(eventId, title, location, snk, vendor, desc, path, price, capacity, tanggal);
        this.namaPembicara = namaPembicara;
    }

    public String getNamaPembicara() {
        return namaPembicara;
    }

    public void setNamaPembicara(String namaPembicara) {
        this.namaPembicara = namaPembicara;
    }

}
