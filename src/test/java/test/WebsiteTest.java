package test;

import org.example.Database;
import org.example.User;
import org.example.Website;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebsiteTest {

    private Database database;

    @BeforeEach
    public void beforeEach() {
        System.out.println("Start of new Test!");
        //Mocka en ny Databas
        database = mock(Database.class);
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

        //Skapa ett föredefinierat User objekt
        User user = new User();
        user.setUsername("Joe");
        user.setPassword("joe1225");

        //Placera User objekt som response till GetUserByUsername metod
        when(database.GetUserByUsername("Joe")).thenReturn(user);

        //Utför test mot Login
        boolean success = website.logIn("Joe", "joe1225");

        assertTrue(success);
        assertEquals(website.currentUser.getUsername(), user.getUsername());
    }

}
