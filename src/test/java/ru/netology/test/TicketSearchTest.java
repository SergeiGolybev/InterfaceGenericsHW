
package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.FindTicketByFast;
import ru.netology.manager.TicketManager;
import ru.netology.repository.Repository;

public class TicketSearchTest {

    @Test
    public void shouldFindFasterTicketInMany() {
        Repository tickets = new Repository();
        FindTicketByFast comparator = new FindTicketByFast();
        TicketManager ticketManager = new TicketManager(tickets);
        Ticket ticket1 = new Ticket(1, 23784, "SVO", "BKK", 1275);
        Ticket ticket2 = new Ticket(2, 28950, "SVO", "AYT", 315);
        Ticket ticket3 = new Ticket(3, 49989, "SVO", "NYC", 2800);
        Ticket ticket4 = new Ticket(4, 89990, "SVO", "WLG", 3200);
        Ticket ticket5 = new Ticket(5, 51900, "SVO", "NYC", 2950);
        Ticket ticket6 = new Ticket(6, 56780, "SVO", "NYC", 3080);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        Ticket[] actual = ticketManager.findAll("SVO", "NYC", comparator);
        Ticket[] expected = {ticket3, ticket5, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFasterTicketInEmpty() {
        Repository tickets = new Repository();
        FindTicketByFast comparator = new FindTicketByFast();
        TicketManager ticketManager = new TicketManager(tickets);
        Ticket[] actual = ticketManager.findAll("SVO", "NYC", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFasterTicketInOne() {
        Repository tickets = new Repository();
        FindTicketByFast comparator = new FindTicketByFast();
        TicketManager ticketManager = new TicketManager(tickets);
        Ticket ticket1 = new Ticket(1, 23784, "SVO", "NYC", 1275);
        ticketManager.add(ticket1);
        Ticket[] actual = ticketManager.findAll("SVO", "NYC", comparator);
        Ticket[] expected = {ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFasterTicketInEqualTime() {
        Repository tickets = new Repository();
        FindTicketByFast comparator = new FindTicketByFast();
        TicketManager ticketManager = new TicketManager(tickets);
        Ticket ticket1 = new Ticket(1, 23784, "SVO", "BKK", 1275);
        Ticket ticket2 = new Ticket(2, 28950, "SVO", "AYT", 1275);
        Ticket ticket3 = new Ticket(3, 49989, "SVO", "NYC", 1275);
        Ticket ticket4 = new Ticket(4, 89990, "SVO", "WLG", 1275);
        Ticket ticket5 = new Ticket(5, 51900, "SVO", "NYC", 1275);
        Ticket ticket6 = new Ticket(6, 56780, "SVO", "NYC", 1275);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        Ticket[] actual = ticketManager.findAll("SVO", "NYC", comparator);
        Ticket[] expected = {ticket3, ticket5, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

}