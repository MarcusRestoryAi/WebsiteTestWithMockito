package test;

import org.example.Rektangel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RektangelTest {

    private Rektangel rektangel;

    @BeforeEach
    public void beforeEach() {
        //Skapa ett obejkt av klassen rektangel
        rektangel = new Rektangel(10, 5);
    }


    @Test
    public void createRektangel() {
        //Kontrollera storleken från Konstruktorn
        assertEquals(rektangel.length, 10);
        assertEquals(rektangel.width, 5);
    }

    @Test
    public void changeSize() {
        //Ända rektangels storlek
        rektangel.setSize(8, 7);

        //Kontrollera storleken
        assertEquals(rektangel.length, 8);
        assertEquals(rektangel.width, 7);
    }

    @Test
    public void getArea() {
        //kontrollera rektangel area
        assertEquals(rektangel.getArea(), 50);

        //Ändra storlek
        rektangel.setSize(20, 10);

        //Kontrollera area igen
        assertEquals(rektangel.getArea(), 200);
    }

    @Test
    public void isSquare() {
        //Kontrollera om rektangel är kvadrat. Det är den inte
        assertFalse(rektangel.isSquare());

        //Ändra storlek till kvadrat
        rektangel.setSize(10, 10);

        //Kontrollera om den är kvadrat nu
        assertTrue(rektangel.isSquare());
    }
}
