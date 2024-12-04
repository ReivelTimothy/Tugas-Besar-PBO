package Main;

import java.sql.Date;
import java.util.ArrayList;

import Models.classes.Event;
import Models.classes.EventConcert;
import Models.classes.EventEducation;
import Models.classes.EventSport;
import Models.classes.Ticket;
import Models.classes.Transaction;
import Models.classes.UserCustomer;
import Models.enumaration.Membership;
import Models.enumaration.TransactionStatus;
import Models.enumaration.statusBlocked;

public class Main {
    public static void main(String[] args) {
        EventEducation eventEducation = new EventEducation(
            "Java Conference",
            "Online",
            "Tech",
            "Vendor1",
            "2024-12-15 10:00",
            "Learn Java programming.",
            100.0,
            20.0,
            5,
            "John Doe",
            Date.valueOf("2024-12-15")
        );

        EventConcert eventConcert = new EventConcert(
            "Music Fest",
            "Stadium",
            "Concert",
            "Vendor2",
            "2024-12-20 18:00",
            "Live music performance.",
            150.0,
            10.0,
            4,
            Date.valueOf("2024-12-18"),
            "The Rockers",
            "Steven Pangestu"
        );

        EventSport eventSport = new EventSport(
            "Football Match",
            "Football Field",
            "Sports",
            "Vendor3",
            "2024-12-25 14:00",
            "Watch the big football match.",
            80.0,
            5.0,
            3,
            "Football",
            Date.valueOf("2024-12-25")
        );

        ArrayList<Event> events = new ArrayList<>();
        events.add(eventEducation);
        events.add(eventConcert);
        events.add(eventSport);

        Transaction transaction = new Transaction(
            1,
            123,
            300.0,
            TransactionStatus.PAID,
            events
        );

        ArrayList<Ticket> tickets = new ArrayList<>();
        UserCustomer userCustomer = new UserCustomer(
            1,
            "Alice",
            "password123",
            "123456789",
            "alice@example.com",
            Membership.ACTIVE,
            "1234567890123456",
            500.0,
            tickets,
            statusBlocked.BLOCK
        );
    }
}
