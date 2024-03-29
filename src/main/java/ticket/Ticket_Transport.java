package ticket;

import person.Person;
import ticket.Ticket;

public class Ticket_Transport extends Ticket {

    public Ticket_Transport(Person person, double paidAmount, boolean split){
        super.paidAmount = paidAmount;
        super.person = person;
        super.split = split;
    }

    @Override
    public String getTicketType()
    {
        return "Transport";
    }
}