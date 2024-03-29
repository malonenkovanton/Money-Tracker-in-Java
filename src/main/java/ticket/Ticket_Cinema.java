package ticket;

import person.Person;
import ticket.Ticket;

public class Ticket_Cinema extends Ticket {
    public Ticket_Cinema(Person person, double paidAmount, boolean split){
        super.paidAmount = paidAmount;
        super.person = person;
        super.split = split;
    }

    @Override
    public String getTicketType() {
        return "Cinema";
    }
}
