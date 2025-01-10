package Models.Classess;

import java.util.Date;

import Models.Enumeration.EventCat;

public abstract class Event {
    int eventId;
    String title, location, desc, path;
    double price;
    int capacity;
    Date tanggal;
    EventCat category;

    public Event(int eventId, String title, String desc,
            String path, double price, int capacity, Date tanggal, EventCat cat) {
        this.eventId = eventId;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.capacity = capacity;
        this.tanggal = tanggal;
        this.path = path;
        this.category = cat;
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


    public EventCat getCategory() {
        return category;
    }


    public void setCategory(EventCat category) {
        this.category = category;
    }

}
