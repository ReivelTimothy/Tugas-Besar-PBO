package Models.Enumeration;

public interface Subject {
    void registerObserver(Member observer);
    void removeObserver(Member observer);
    void notifyObservers(String message);
}
