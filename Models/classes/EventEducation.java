package Models.classes;

import java.util.Date;

public class EventEducation extends Event {
    String namaPembicara;

    public EventEducation(String title, String location, String snk, String vendor, String dateTime, String information,
            double price, double discount, int rating, String namaPembicara, Date date) {
        super(title, location, snk, vendor, dateTime, information, price, discount, rating, date);
        this.namaPembicara = namaPembicara;
    }

    public String getNamaPembicara() {
        return namaPembicara;
    }

    public void setNamaPembicara(String namaPembicara) {
        this.namaPembicara = namaPembicara;
    }

    @Override
    public String toString() {
        return "EventEducation [title=" + title + ", location=" + location + ", namaPembicara=" + namaPembicara
                + ", snk=" + snk + ", vendor=" + vendor + ", dateTime=" + dateTime + ", information=" + information
                + ", price=" + price + ", discount=" + discount + ", rating=" + rating + ", tanggal=" + tanggal
                ;
    }
    
}
