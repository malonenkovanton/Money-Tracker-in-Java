package controller;

import database.RegistrationPeople;
import factory.AFact;
import database.PeopleDB;
import database.TicketsDB;
import person.Person;
import ticket.Ticket;

import java.awt.geom.AffineTransform;
import java.util.Arrays;

public class RegisterController {

    private PeopleDB peopleDB;
    private TicketsDB ticketsDB;
    private AFact factory;

    public RegisterController(PeopleDB peopleDB, TicketsDB ticketsDB, AFact fact)
    {
        this.peopleDB = peopleDB;
        this.ticketsDB = ticketsDB;
        this.factory = fact;
    }

//    public void addEvent(Person person, double paidAmount, int eventType)
//    {
//        Ticket t = factory.makeTicket(eventType, person,paidAmount);
//        ticketsDB.addTicket(t);
//        person.addTicket(t);
//    }

    public void addTicket(Ticket ticket)
    {
        this.ticketsDB.addTicket(ticket);
    }
    public void addPerson(String name)
    {
        this.peopleDB.addPerson(factory.createPerson(name));
    }

    public void removePerson(Person person)
    {
        this.peopleDB.removePerson(person);
    }
    public void printPeopleDatabase()
    {
        peopleDB.printDatabase();
    }

    public PeopleDB getPeopleDB() {
        return peopleDB;
    }

    public TicketsDB getTicketsDB() {
        return ticketsDB;
    }
    public AFact getFactory()
    {
        return factory;
    }

    public void printTicketDatabase()
    {
        ticketsDB.printDatabase();
    }
    public void printBill(){
        peopleDB.totalBill();
    }
    public String[] getNames()
    {

        return peopleDB.getList().stream().map(Person::getName).toArray(String[]::new);
        //Code from: https://stackoverflow.com/questions/27693236/converting-list-of-objects-to-an-array-of-strings
    }
}

