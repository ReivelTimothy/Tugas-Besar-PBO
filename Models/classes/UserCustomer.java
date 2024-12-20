package Models.classes;

import java.util.ArrayList;

import Models.enumaration.Membership;
import Models.enumaration.StatusBlocked;

public class UserCustomer extends User {
    private Membership statusMembership;
    private String cardNumber;
    private double balance;
    private ArrayList<Ticket> listTicket = new ArrayList<>();
    private StatusBlocked blockedStatus;
    
    public UserCustomer(int iD_karyawan, String name, String password, String noTlp, String email,
            Membership statusMembership, String cardNumber, double balance, ArrayList<Ticket> listTicket,
            StatusBlocked blockedStatus) {
        super(iD_karyawan, name, password, noTlp, email);
        this.statusMembership = statusMembership;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.listTicket = listTicket;
        this.blockedStatus = blockedStatus;
    }
    
    public Membership getStatusMembership() {
        return statusMembership;
    }
    public void setStatusMembership(Membership statusMembership) {
        this.statusMembership = statusMembership;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public ArrayList<Ticket> getListTicket() {
        return listTicket;
    }
    public void setListTicket(ArrayList<Ticket> listTicket) {
        this.listTicket = listTicket;
    }
    public StatusBlocked getBlockedStatus() {
        return blockedStatus;
    }
    public void setBlockedStatus(StatusBlocked blockedStatus) {
        this.blockedStatus = blockedStatus;
    }

}
