package models.classes;

import java.util.ArrayList;
import models.enumaration.*;

public class UserCustomer extends User {
    private Membership statusMembership;
    private ArrayList<Transaction> listTransactions = new ArrayList<>();

    public UserCustomer(String name, String password, String noTlp, String email,int id,  Membership statusMembership) {
        super(id, name, password, noTlp, email);
        this.statusMembership = statusMembership;
    }

    public Membership getStatusMembership() {
        return statusMembership;
    }

    public void setStatusMembership(Membership statusMembership) {
        this.statusMembership = statusMembership;
    }

    public ArrayList<Transaction> getListTransactions() {
        return listTransactions;
    }

    public void setListTransactions(ArrayList<Transaction> listTransactions) {
        this.listTransactions = listTransactions;
    }
    
}
