package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class TicketManager {

    private Repository ticket;

    public TicketManager(Repository ticket) {
        this.ticket = ticket;
    }

    public void add(Ticket tickets) {
        ticket.add(tickets);
    }

    public boolean searchByDeparture(Ticket ticket, String searchDeparture, String searchArrival) {
        if (ticket.getDepartureAirport().contains(searchDeparture)
                && ticket.getArrivalAirport().contains(searchArrival)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : ticket.findAll()) {
            if (searchByDeparture(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}