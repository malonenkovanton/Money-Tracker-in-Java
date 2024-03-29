package database;
import person.Person;
import ticket.Ticket;

import java.util.*;

public class RegistrationTickets extends TicketsDB {

    private final ArrayList<Ticket> tickets;
    private volatile static RegistrationTickets registrationTicket_instance;
    private List<Observer> observers;
    private Ticket key;
    private RegistrationTickets()
    {
        this.tickets = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static RegistrationTickets getInstance()
    {
        if(registrationTicket_instance == null) {
            synchronized (RegistrationTickets.class) {
                if (registrationTicket_instance == null)
                    registrationTicket_instance = new RegistrationTickets();
            }
        }
        return registrationTicket_instance;
    }
    // Source: Head First Design Patterns page 182

    @Override
    public void addTicket(Ticket t) {
        this.tickets.add(t);
        setChanged();
        this.key = t;
        this.notifyObservers();
    }

    @Override
    public void printDatabase()
    {
        System.out.println("\n---- Active Tickets -----");
        java.util.Iterator<Ticket> it = tickets.iterator();
        if(tickets.size()!=0) {
            while(it.hasNext())
            {
                Ticket t = it.next();
                System.out.println(t.getTicketType() + ", " + t.getPaidAmount()+"eur" + " was paid by " +t.getPayer().getName() + ". Even split? " + t.getSplit());
            }
        }else System.out.println("There are no tickets");
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        ListIterator<Observer> it = observers.listIterator();
        while(it.hasNext())
        {
            it.next().update(this,key);
        }
    }

    @Override
    public ArrayList<Ticket> getList() {
        return this.tickets;
    }
}