package org.example;

public class PurchaseTicket {

    public Ticket ticket;

    public PurchaseTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    //Metod för att kontrollera vinst på ticket
    public boolean checkTicket() {
        //Kontrollera vinst på ticket
        boolean win = ticket.checkWinner();

        if (win) {
            //Vinst
            System.out.println("Du har vunnit");
            return true;
        }
        System.out.println("Du har förlorat");
        return false;
    }
}
