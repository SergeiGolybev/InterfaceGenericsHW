package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.Repository;

public class TicketSearchTest {

    @Test
    public void shouldAddTickets() {
        Repository tickets = new Repository();
        Ticket ticket1 = new Ticket(1, 23784, "SVO", "BKK", 1275);
        Ticket ticket2 = new Ticket(2, 28950, "SVO", "AYT", 315);
        Ticket ticket3 = new Ticket(3, 49989, "SVO", "NYC", 2800);
        Ticket ticket4 = new Ticket(4, 89990, "SVO", "WLG", 3200);
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        Ticket[] actual = tickets.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {
        Repository tickets = new Repository();
        Ticket ticket1 = new Ticket(1, 23784, "SVO", "BKK", 1275);
        Ticket ticket2 = new Ticket(2, 28950, "SVO", "AYT", 315);
        Ticket ticket3 = new Ticket(3, 49989, "SVO", "NYC", 2800);
        Ticket ticket4 = new Ticket(4, 89990, "SVO", "WLG", 3200);
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.removeById(3);
        Ticket[] actual = tickets.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicket() {
        Repository tickets = new Repository();
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
        Ticket[] actual = ticketManager.findAll("SVO", "NYC");
        Ticket[] expected = {ticket3, ticket5, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindInEmpty() {
        Repository tickets = new Repository();
        TicketManager ticketManager = new TicketManager(tickets);
        Ticket[] actual = ticketManager.findAll("SVO", "NYC");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindInOneTicket() {
        Repository tickets = new Repository();
        TicketManager ticketManager = new TicketManager(tickets);
        Ticket ticket1 = new Ticket(1, 23784, "SVO", "BKK", 1275);
        tickets.add(ticket1);
        Ticket[] actual = ticketManager.findAll("SVO", "BKK");
        Ticket[] expected = {ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindInManyTickets() {
        Repository tickets = new Repository();
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
        Ticket[] actual = ticketManager.findAll("SVO", "BKK");
        Ticket[] expected = {ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMissingTicket() {
        Repository tickets = new Repository();
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
        Ticket[] actual = ticketManager.findAll("SVO", "DMD");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}