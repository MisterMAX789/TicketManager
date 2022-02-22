package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket ticket) {
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        items = tmp;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : items) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        items = tmp;

    }

    public Ticket[] getAll() {
        return items;
    }
}