package parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotDisplayTest {
    @Test
    void shouldReturnParkingLotDetails() {
        ParkingLotDisplay parkingLotDisplay = ParkingLotDisplay.getInstance();

        parkingLotDisplay.update("PL1", 2);
        parkingLotDisplay.update("PL2", 3);
        parkingLotDisplay.update("PL3", 4);

        String expected = "PL1\t2\n" +
                "PL2\t3\n" +
                "PL3\t4";

        assertEquals(expected, parkingLotDisplay.toString());
    }
}