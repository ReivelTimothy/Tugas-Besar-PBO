package Models.Classess;

import java.util.Date;

import Models.Enumeration.EventCat;

public class EventConcert extends Event {
    String jenisKonser, singer;

    public EventConcert(int eventId, String title,
            String desc, String path, double price, int capacity, Date tanggal, String jenisKonser,
            String singer, Double income) {
        super(eventId, title, desc, path, price, capacity, tanggal, EventCat.MUSIC, income);
        this.jenisKonser = jenisKonser;
        this.singer = singer;
    }
    public EventConcert(int eventId, String title,
            String desc, String path, double price, int capacity, Date tanggal, String jenisKonser,
            String singer) {
        super(eventId, title, desc, path, price, capacity, tanggal, EventCat.MUSIC, 0.0);
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
