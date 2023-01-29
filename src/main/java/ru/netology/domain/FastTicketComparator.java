package ru.netology.domain;

import java.util.Comparator;

public class FastTicketComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getTimeInMinutes() < o2.getTimeInMinutes()) {
            return -1;
        } else if (o1.getTimeInMinutes() > o2.getTimeInMinutes()) {
            return 1;
        } else {
            return 0;
        }
    }
}
