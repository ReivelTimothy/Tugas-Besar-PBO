package Models.Classess;

import java.sql.Date;

import Models.Enumeration.EventCat;

public class EventEducation extends Event {
    String namaPembicara;

    public EventEducation(int eventId, String title,
            String desc, String path, double price, int capacity, Date tanggal,
            String namaPembicara, Double income) {
        super(eventId, title, desc, path, price, capacity, tanggal, EventCat.EDUCATION, income);
        this.namaPembicara = namaPembicara;
    }

    public EventEducation(int eventId, String title,
            String desc, String path, double price, int capacity, Date tanggal,
            String namaPembicara) {
        super(eventId, title, desc, path, price, capacity, tanggal, EventCat.EDUCATION, 0.0);
        this.namaPembicara = namaPembicara;
    }

    public String getNamaPembicara() {
        return namaPembicara;
    }

    public void setNamaPembicara(String namaPembicara) {
        this.namaPembicara = namaPembicara;
    }

}
