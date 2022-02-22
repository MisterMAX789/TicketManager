package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAllOffers() {
        Ticket[] result = repository.getAll();
        Arrays.sort(result);
        return result;
    }
}