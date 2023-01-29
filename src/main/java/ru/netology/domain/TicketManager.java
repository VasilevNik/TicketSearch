package ru.netology.domain;

import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {

        this.repository = repository;
    }

    public void add(Ticket ticket) {

        repository.add(ticket);
    }

    public Ticket[] findByDepartureAirport(String airportDeparture) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesDeparture(ticket, airportDeparture)) {
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

    public Ticket[] findByArrivalAirport(String airportArrival) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesArrival(ticket, airportArrival)) {
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

    public Ticket[] findAll(String airportDeparture, String airportArrival) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, airportDeparture, airportArrival)) {
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

    public Ticket[] findAllFast(String airportDeparture, String airportArrival, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, airportDeparture, airportArrival)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches(Ticket ticket, String airportDeparture, String airportArrival) {
        if (ticket.getAirportDeparture().equals(airportDeparture)) {
            if (ticket.getAirportArrival().equals(airportArrival)) {
                return true;
            }
        }
        return false;
    }


    public boolean matchesDeparture(Ticket ticket, String search) {
        if (ticket.getAirportDeparture().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesArrival(Ticket ticket, String search) {
        if (ticket.getAirportArrival().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}