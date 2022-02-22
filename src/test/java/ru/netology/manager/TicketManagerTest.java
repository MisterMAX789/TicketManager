package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

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
        repo.save(fourth);
    }

    @Test
    public void shouldFindByNumber() {
        Ticket[] expected = {fourth};
        assertArrayEquals(expected, manager.findAll(CDG, LED));
    }

    @Test
    public void shouldFindByAnotherNumber() {
        Ticket[] expected = {second};
        assertArrayEquals(expected, manager.findAll(LHR, CDG));
    }

    @Test
    public void shouldShowAllOffers() {
        Ticket[] expected = {second, first, fourth, third};
        assertArrayEquals(expected, manager.findAllOffers());
    }

    @Test
    public void shouldSortByLowerPrice() {
        Ticket[] expected = {second, first, fourth, third};
        Ticket[] actual = {first, second, third, fourth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}