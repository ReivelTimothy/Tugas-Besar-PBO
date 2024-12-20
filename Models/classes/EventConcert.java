package Models.classes;

import java.util.Date;

public class EventConcert extends Event {
    String jenisKonser, singer;
    
    

    public EventConcert(int eventId, String title, String location, String snk, String vendor,
            String desc, String timeStart, String timeEnd, double price, int capacity, Date tanggal, String jenisKonser,
            String singer) {
        super(eventId, title, location, snk, vendor, desc, timeStart, timeEnd, price, capacity, tanggal);
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
