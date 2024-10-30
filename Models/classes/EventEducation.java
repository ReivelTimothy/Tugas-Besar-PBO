package models.classes;

import java.sql.Date;

public class EventEducation extends Eventt {
    String namaPembicara;

    public EventEducation(String title, String location, String snk, String vendor, String dateTime, String information,
            double price, double discount, int rating, String namaPembicara,Date tanggal) {
        super(title, location, snk, vendor, dateTime, information, price, discount, rating, tanggal);
        this.namaPembicara = namaPembicara;
    }

    public String getNamaPembicara() {
        return namaPembicara;
    }

    public void setNamaPembicara(String namaPembicara) {
        this.namaPembicara = namaPembicara;
    }
    
}
