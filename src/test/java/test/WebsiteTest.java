package test;

import org.example.Database;
import org.example.User;
import org.example.Website;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class WebsiteTest {

    private Database database;
    private User user;

    @BeforeEach
    public void beforeEach() {
        System.out.println("Start of new Test!");
        //Mocka en ny Databas
        database = mock(Database.class);

        //Skapa ett föredefinierat User objekt
        user = new User();
        user.setUsername("Joe");
        user.setPassword("joe1225");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test done!");
    }

    @Test
    public void testLogin() {
        Website website = new Website();
        //Placera mockad databas i Website attribut
        website.userDatabase = database;

        //Placera User objekt som response till GetUserByUsername metod
        //when(database.GetUserByUsername("Joe")).thenReturn(user);
        when(database.GetUserByUsername(any())).thenReturn(user);
        when(database.GetUserByUsername(anyString())).thenReturn(user);

        //Utför test mot Login
        boolean success = website.logIn("Joe", "joe1225");

        assertTrue(success);
        assertEquals(website.currentUser.getUsername(), user.getUsername());
    }

    @Test
    public void changeNameTest() {
        //Skapa en Website och implementera mockad databas
        Website website = new Website();
        website.userDatabase = database;

        //Mockar en inloggning
        when(database.GetUserByUsername("Joe")).thenReturn(user);
        website.logIn("Joe", "joe1225");

        //Utför byte av Username
        boolean success = website.changeName("Joakim");

        //Kontrollerar att Metod i Databas anropas
        verify(database, times(1)).SaveNewUsername("Joe", "Joakim");
        assertEquals(website.currentUser.getUsername(), "Joakim");
        assertTrue(success);
    }

    @Test
    public void changeNameNullUserTest() {
        //Skapa en Website och implementera mockad databas
        Website website = new Website();
        website.userDatabase = database;

        //Utför byte av Username
        boolean success = website.changeName("Joakim");

        //Kontrollerar att Metod i Databas anropas
        verify(database, never()).SaveNewUsername(any(), any());
        assertFalse(success);
    }

}
