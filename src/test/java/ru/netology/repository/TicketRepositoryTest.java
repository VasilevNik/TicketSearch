package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {

    TicketRepository repository = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 3710, "DME", "OVB", 245);// Домодедово - Новосибирск
    Ticket ticket2 = new Ticket(2, 2200, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 2120, "VKO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 3500, "DME", "OVB", 245);
    Ticket ticket5 = new Ticket(5, 3450, "DME", "OVB", 245);
    Ticket ticket6 = new Ticket(6, 7600, "DME", "OVB", 250);
    Ticket ticket7 = new Ticket(7, 7100, "DME", "OVB", 250);


    @BeforeEach
    public void setup() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);
        repository.add(ticket7);
    }

    @Test
    public void removeTicketById() {

        repository.removeById(ticket7.getId());
        repository.removeById(ticket1.getId());

        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }


}
