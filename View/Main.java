package view;

import java.util.ArrayList;

import models.DataDummy;
import models.classes.EventEducation;
import models.classes.Eventt;
import models.classes.Transaction;
import models.classes.User;
import models.classes.UserCustomer;
import models.enumaration.Membership;

public class Main {
    public static void main(String[] args) {
        // DataDummy.generate();
        Eventt event1 = new EventEducation("tetest", null, null, null, null, "hihihaha", 0, 0, 0, null, null);
        Eventt event2 = new EventEducation("tetest", null, null, null, null, "muhahaha", 0, 0, 0, null, null); 
        User user2 = new UserCustomer("Reivel", "12345", "0987123", "hihaha@gmail,com", 1,Membership.ACTIVE);
        ArrayList<Eventt> events = new ArrayList<>(); 
        Transaction transaction = new Transaction(0, 0, 0, null, null);
        events.add(event2);
        events.add(event1);
        transaction.setListEvent(events);
        ArrayList<Transaction> tempTransactions = user2.getListTiket();
        Transaction transaction2 = new Transaction(1, 2, 0, null, null);
        tempTransactions.add(transaction);
        user2.setListTiket(tempTransactions);
    
        System.out.println(user2.getListTiket().get(0).getListEvent().get(0).getInformation());
        System.out.println("nama : " + user2.getName());
        System.out.println("list tiket : ");
        for (int i = 0; i < user2.getListTiket().size() + 1; i++) {
            System.out.println("title " + user2.getListTiket().get(0).getListEvent().get(i).getInformation());
        }
    }
}
