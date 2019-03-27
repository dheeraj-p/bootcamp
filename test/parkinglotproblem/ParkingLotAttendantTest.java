package parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotAttendantTest {

    @Test
    void shouldNotifyAssistantToUpdateDisplayWheneverAParkingLotUpdateComes() {
        MockedAssistant mockedAssistant = new MockedAssistant();
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(mockedAssistant);

        parkingLotAttendant.updateDisplay("PL", 2);
        assertTrue(mockedAssistant.isUpdated);
    }
}

class MockedAssistant extends ParkingLotAssistant{
    boolean isUpdated = false;

    @Override
    void updateDisplay(String parkingLotName, Integer numberOfCars){
        isUpdated = true;
    }
}