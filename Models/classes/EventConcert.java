package Models.classes;

import java.sql.Date;

public abstract class EventConcert extends Event{
    String jenisKonser, singer;
    public EventConcert(String title, String location, String snk, String vendor, String dateTime, String information,
            double price, double discount, int rating, String jenisKonser, String singer, Date tanggal) {
        super(title, location, snk, vendor, dateTime, information, price, discount, rating, tanggal);
        this.jenisKonser = jenisKonser;
        this.singer = singer;
    }

    public String getJenisKonser() {
        return jenisKonser;
    }

    public void setJenisKonser(String jenisKonser) {
        this.jenisKonser = jenisKonser;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    
}
