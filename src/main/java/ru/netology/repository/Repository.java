package ru.netology.repository;

import ru.netology.domain.Ticket;

public class Repository {

    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] newTickets = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            newTickets[i] = tickets[i];
        }
        newTickets[newTickets.length - 1] = ticket;
        tickets = newTickets;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        Ticket[] newTickets = new Ticket[tickets.length - 1];
        int i = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                newTickets[i] = ticket;
                i++;
            }
        }
        tickets = newTickets;
    }
}

