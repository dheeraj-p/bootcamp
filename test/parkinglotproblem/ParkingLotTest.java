package parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldParkACarInTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(5, "PL");

        Integer token = parkingLot.park(new Car());

        assertNotNull(token);
    }

    @Test
    void shouldNotParkWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1, "PL");
        parkingLot.park(new Car());
        Integer token = parkingLot.park(new Car());

        assertNull(token);
    }

    @Test
    void shouldNotifyAttendantWhenTheLotIsFull() {

        ParkingLot parkingLot = new ParkingLot(2, "PL");
        TestAttendant testAttendant = new TestAttendant(new ParkingLotAssistant());
        parkingLot.registerAttendant(testAttendant);

        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertEquals(1, testAttendant.numberOfTimesNotifiedForParkingLotFull);
    }

    @Test
    void shouldNotifyAttendantWhenMoreThanOneParkingLotsAreFull() {

        ParkingLot parkingLot1 = new ParkingLot(1, "PL");
        ParkingLot parkingLot2 = new ParkingLot(1, "PL2");
        TestAttendant testAttendant = new TestAttendant(new ParkingLotAssistant());

        parkingLot1.registerAttendant(testAttendant);
        parkingLot2.registerAttendant(testAttendant);

        parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        assertEquals(2, testAttendant.numberOfTimesNotifiedForParkingLotFull);
    }

    @Test
    void shouldUnParkACarForGivenValidToken() {
        ParkingLot parkingLot = new ParkingLot(2, "PL");
        Integer token = parkingLot.park(new Car());

        assertTrue(parkingLot.unPark(token));
    }

    @Test
    void shouldNotUnParkACarForGivenInvalidToken() {
        ParkingLot parkingLot = new ParkingLot(2, "PL");
        Integer token = parkingLot.park(new Car());

        assertFalse(parkingLot.unPark(token - 1));
    }

    @Test
    void shouldNotifyTheAttendantWhenAFullLotBecomesFree() {
        ParkingLot parkingLot = new ParkingLot(2, "PL");
        TestAttendant testAttendant = new TestAttendant(new ParkingLotAssistant());
        parkingLot.registerAttendant(testAttendant);

        parkingLot.park(new Car());
        Integer token = parkingLot.park(new Car());
        parkingLot.unPark(token);
        assertEquals(1, testAttendant.numberOfTimesNotifiedForParkingLotFree);

    }

    @Test
    void shouldNotifyTheAttendantToUpdateDisplayWheneverACarIsParked() {

        ParkingLot parkingLot = new ParkingLot(1, "PL");
        TestAttendant testAttendant = new TestAttendant(new ParkingLotAssistant());
        parkingLot.registerAttendant(testAttendant);

        parkingLot.park(new Car());
        assertEquals(1, testAttendant.numberOfTimesDisplayUpdated);
    }

    @Test
    void shouldNotifyTheAttendantToUpdateDisplayWheneverACarIsUnParked() {

        ParkingLot parkingLot = new ParkingLot(1, "PL");
        TestAttendant testAttendant = new TestAttendant(new ParkingLotAssistant());
        parkingLot.registerAttendant(testAttendant);

        Integer token = parkingLot.park(new Car());
        parkingLot.unPark(token);
        assertEquals(2,testAttendant.numberOfTimesDisplayUpdated);
    }

}

class TestAttendant extends ParkingLotAttendant {
    int numberOfTimesNotifiedForParkingLotFull = 0;
    int numberOfTimesNotifiedForParkingLotFree = 0;
    int numberOfTimesDisplayUpdated = 0;

    TestAttendant(ParkingLotAssistant assistant) {
        super(assistant);
    }

    @Override
    void notifyLotFull(ParkingLot parkingLot) {
        numberOfTimesNotifiedForParkingLotFull++;
    }

    @Override
    void notifyLotFree(ParkingLot parkingLot) {
        numberOfTimesNotifiedForParkingLotFree++;
    }

    @Override
    void updateDisplay(String parkingLotName, int numberOfCars) {
        numberOfTimesDisplayUpdated++;
    }
}