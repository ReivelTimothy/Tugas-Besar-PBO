package Models.Classess;

import java.sql.Date;

import Models.Enumeration.EventCat;

public class EventEducation extends Event {
    String namaPembicara;

    public EventEducation(int eventId, String title,
            String desc, String path, double price, int capacity, Date tanggal,
            String namaPembicara) {
        super(eventId, title, desc, path, price, capacity, tanggal, EventCat.EDUCATION);
        this.namaPembicara = namaPembicara;
    }

    public String getNamaPembicara() {
        return namaPembicara;
    }

    public void setNamaPembicara(String namaPembicara) {
        this.namaPembicara = namaPembicara;
    }

}
