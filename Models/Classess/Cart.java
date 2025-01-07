package Models.Classess;

public class Cart {
    private int cart_id;
    private Event event;
    private Ticket ticket;
    private UserCustomer customer;
    
    public Cart(int cart_id, Event event, Ticket ticket, UserCustomer customer) {
        this.cart_id = cart_id;
        this.event = event;
        this.ticket = ticket;
        this.customer = customer;
    }
    public int getCart_id() {
        return cart_id;
    }
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public UserCustomer getCustomer() {
        return customer;
    }
    public void setCustomer(UserCustomer customer) {
        this.customer = customer;
    }
}
