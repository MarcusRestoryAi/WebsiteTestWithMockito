package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PurchaseTicketTest {

    private Ticket ticket;

    @BeforeEach
    public void beforeEach() {
        ticket = mock(Ticket.class);
    }

    @Test
    void checkTicketForWin() {
        //Skapa en PurcahseTicket klass
        PurchaseTicket purchaseTicket = new PurchaseTicket(ticket);

        //Setup av Mock
        when(ticket.checkWinner()).thenReturn(true);

        //Test
        assertTrue(purchaseTicket.checkTicket());
    }

    @Test
    void checkTicketForLoss() {
        //Skapa en PurcahseTicket klass
        PurchaseTicket purchaseTicket = new PurchaseTicket(ticket);

        //Setup av Mock
        when(ticket.checkWinner()).thenReturn(false);

        //Test
        assertFalse(purchaseTicket.checkTicket());
    }

    @Test
    void checkForWinAtTen() {
        //Skapa en PurcahseTicket klass
        PurchaseTicket purchaseTicket = new PurchaseTicket(ticket);

        //Setup av Mock
        when(ticket.checkWinner()).thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(false)
                .thenReturn(true);

        //Exekvering av Test
        for (int i = 0; i < 9; i++) {
            assertFalse(purchaseTicket.checkTicket());
        }
        assertTrue(purchaseTicket.checkTicket());
    }
}