package ticket;

import person.Person;

public abstract class Ticket {
    protected double paidAmount;
    protected Person person;
    protected boolean split;

    public Person getPayer()
    {
        return person;
    }
    public double getPaidAmount()
    {
        return paidAmount;
    }
    public String toString()
    {
        return String.format("%s paid ''%s'', %seur",this.getPayer().getName(),this.getTicketType(),this.getPaidAmount());
    }
    public boolean getSplit(){
        return split;
    }

    public abstract String getTicketType();
}
