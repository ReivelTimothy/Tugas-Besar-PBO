package Models.classes;

import java.sql.Date;

public class EventConcert extends Event{
    private String jenisKonser, singer;

    public EventConcert(String title, String location, String snk, String vendor, String dateTime, String information,
            double price, double discount, int rating, Date tanggal, String jenisKonser, String singer) {
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
