package Models.Classess;

import java.util.Date;

public abstract class Event {
    int eventId;
    String title, location, snk, vendor, desc, path;
    double price;
    int capacity;
    Date tanggal;

    public Event(int eventId, String title, String location, String snk, String vendor, String desc,
            String path, double price, int capacity, Date tanggal) {
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.snk = snk;
        this.vendor = vendor;
        this.desc = desc;
        this.price = price;
        this.capacity = capacity;
        this.tanggal = tanggal;
        this.path = path;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSnk() {
        return snk;
    }

    public void setSnk(String snk) {
        this.snk = snk;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
