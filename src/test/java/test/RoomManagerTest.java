package test;

import org.example.RoomManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomManagerTest {

    private RoomManager roomManager;

    @BeforeEach
    public void beforeEach() {
        roomManager = mock(RoomManager.class);
    }

    @Test
    public void getAvailableRoomsTest() {
        //Skapa ett fördefinierat returvärde
        ArrayList<String> availableRooms = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));

        //Mocka returvärdet
        when(roomManager.getAvailableRooms()).thenReturn(availableRooms);

        //Utföra anropet för att få antalet rum
        int countOfAvailableRooms = roomManager.getAvailableRooms().size();

        //Assert för att jämföra resultatet
        assertEquals(5, countOfAvailableRooms);
    }

    @Test
    public void getAvailableRoomIdTest() {
        //Mock kommer att returnera dessa värden, i ordning
        when(roomManager.getAvailableRoomId())
                .thenReturn("Rum 1")
                .thenReturn("Rum 2")
                .thenReturn("Rum 3")
                .thenReturn("")
                .thenReturn(null);

        //Utför en grupp av Asserts efter varandra
        assertAll(
                () -> assertEquals(roomManager.getAvailableRoomId(), "Rum 1"),
                () -> assertEquals(roomManager.getAvailableRoomId(), "Rum 2"),
                () -> assertEquals(roomManager.getAvailableRoomId(), "Rum 3"),
                () -> assertEquals(roomManager.getAvailableRoomId(), ""),
                () -> assertNull(roomManager.getAvailableRoomId()),
                () -> assertNull(roomManager.getAvailableRoomId()),
                () -> assertNull(roomManager.getAvailableRoomId())
        );
    }
}
