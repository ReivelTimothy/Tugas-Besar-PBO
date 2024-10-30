package models.classes;

import java.util.ArrayList;
import java.util.List;

import models.enumaration.*;

public class Transaction {
    private int idTransaksi;
    private int idCustomer;
    private double totalBayar;
    private TransactionStatus statusTransaksi;
    private List<Eventt> listEvent = new ArrayList<>();

    public Transaction(int idTransaksi, int idCustomer, double totalBayar, TransactionStatus statusTransaksi,
            List<Eventt> listEvent) {
        this.idTransaksi = idTransaksi;
        this.idCustomer = idCustomer;
        this.totalBayar = totalBayar;
        this.statusTransaksi = statusTransaksi;
        this.listEvent = listEvent;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public TransactionStatus getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(TransactionStatus statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public List<Eventt> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<Eventt> listEvent) {
        this.listEvent = listEvent;
    }

}
