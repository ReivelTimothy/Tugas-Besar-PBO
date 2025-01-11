package Models.Classess;

import java.util.ArrayList;
import java.util.List;

import Models.Enumeration.Member;
import Models.Enumeration.Membership;
import Models.Enumeration.Subject;

public class Memberships implements Subject {
    private Membership status;
    private List<Member> observers = new ArrayList<>();

    public Memberships(Membership status) {
        this.status = status;
    }

    public Membership getStatus() {
        return status;
    }

    public void setStatus(Membership status) {
        this.status = status;
        notifyObservers("Membership status changed to: " + status);
    }

    @Override
    public void registerObserver(Member observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Member observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Member observer : observers) {
            observer.update(message);
        }
    }
}