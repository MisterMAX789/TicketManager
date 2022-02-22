package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {

    static TicketRepository repo = new TicketRepository();
    static TicketManager manager = new TicketManager(repo);
    private static final String BUH = "Анри Коанды";
    private static final String LED = "Пулково";
    private static final String LHR = "Хитроу";
    private static final String CDG = "Шарль де Голль";
    private static final String DXB = "Дубай";

    static Ticket first = new Ticket(1937, 4884, BUH, LED, 1270);
    static Ticket second = new Ticket(2050, 2862, LHR, CDG, 80);
    static Ticket third = new Ticket(7692, 31972, DXB, LHR, 475);
    static Ticket fourth = new Ticket(4777, 11744, CDG, LED, 335);


    @BeforeAll
    static void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    public void shouldFindAllGiven() {
        Ticket[] expected = {first, second, third};
        assertArrayEquals(expected, repo.getAll());
    }

    @Test
    public void shouldSaveAdd() {
        repo.save(fourth);
        Ticket[] expected = {first, second, third, fourth};
        Ticket[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(fourth);
        repo.removeById(4777);
        Ticket[] expected = {first, second, third};
        Ticket[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }
}