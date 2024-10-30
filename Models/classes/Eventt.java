package models.classes;

import java.sql.Date;

public abstract class Eventt {
    String title, location, snk, vendor, dateTime, information;
    double price, discount;
    int rating;
    Date tanggal;

    public Eventt(String title, String location, String snk, String vendor, String dateTime, String information,
            double price, double discount, int rating, Date tanggal) {
        this.title = title;
        this.location = location;
        this.snk = snk;
        this.vendor = vendor;
        this.dateTime = dateTime;
        this.information = information;
        this.price = price;
        this.discount = discount;
        this.rating = rating;
        this.tanggal = tanggal;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
