package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 3710, "DME", "OVB", 150);// Домодедово - Новосибирск
    Ticket ticket2 = new Ticket(2, 2200, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 2120, "VKO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 3500, "DME", "OVB", 130);
    Ticket ticket5 = new Ticket(5, 3450, "DME", "OVB", 170);
    Ticket ticket6 = new Ticket(6, 7600, "DME", "OVB", 150);
    Ticket ticket7 = new Ticket(7, 7100, "DME", "OVB", 250);


    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }


    @Test

    public void findForTicketByArrivalAirport() {

        Ticket[] expected = {ticket5, ticket4, ticket1, ticket7, ticket6};
        Ticket[] actual = manager.findByArrivalAirport("OVB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void findForTicketByDepartureAirport() {

        Ticket[] expected = {ticket3, ticket2};
        Ticket[] actual = manager.findByDepartureAirport("VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void findTicketByDepartureAndArrivalAirport() {

        Ticket[] expected = {ticket5, ticket4, ticket1, ticket7, ticket6};
        Ticket[] actual = manager.findAll("DME", "OVB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void enteringIncorrectDataAtTheDepartureAirport() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("NOV", "OVB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void enteringIncorrectDataAtTheArrivalAirport() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DME", "NOV");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void enteringIncorrectDataAtTheDepartureAndArrivalAirport() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("0", "0");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void sortingTicketsWithTheSamePrice() {
        Ticket ticket8 = new Ticket(8, 7100, "DME", "OVB", 250);
        manager.add(ticket8);

        Ticket[] expected = {ticket5, ticket4, ticket1, ticket7, ticket8, ticket6};
        Ticket[] actual = manager.findAll("DME", "OVB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void sortTicketsByFlightTimeFromTheSmallest() {

        FastTicketComparator comparator = new FastTicketComparator();

        Ticket[] expected = {ticket4, ticket1, ticket6, ticket5, ticket7};
        Ticket[] actual = manager.findAllFast("DME", "OVB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
