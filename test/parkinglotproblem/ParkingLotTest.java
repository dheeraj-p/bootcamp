package parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldParkACarInTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(5);

        Integer token = parkingLot.park(new Car());

        assertNotNull(token);
    }

    @Test
    void shouldNotParkWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        Integer token = parkingLot.park(new Car());

        assertNull(token);
    }

    @Test
    void shouldNotifyAttendantWhenTheLotIsFull() {

        ParkingLot parkingLot = new ParkingLot(2);
        TestAttendant testAttendant = new TestAttendant();
        parkingLot.registerAttendant(testAttendant);

        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertTrue(testAttendant.isNotifiedFull);
    }

    @Test
    void shouldUnParkACarForGivenValidToken() {
        ParkingLot parkingLot = new ParkingLot(2);
        Integer token = parkingLot.park(new Car());

        assertTrue(parkingLot.unPark(token));
    }

    @Test
    void shouldNotUnParkACarForGivenInvalidToken() {
        ParkingLot parkingLot = new ParkingLot(2);
        Integer token = parkingLot.park(new Car());

        assertFalse(parkingLot.unPark(token - 1));
    }

    @Test
    void shouldNotifyTheAttendantWhenAFullLotBecomesFree() {
        ParkingLot parkingLot = new ParkingLot(2);
        TestAttendant testAttendant = new TestAttendant();
        parkingLot.registerAttendant(testAttendant);

        parkingLot.park(new Car());
        Integer token = parkingLot.park(new Car());
        parkingLot.unPark(token);
        assertTrue(testAttendant.isNotifiedFree);

    }

}

class TestAttendant extends ParkingLotAttendant {
    boolean isNotifiedFull = false;
    boolean isNotifiedFree = false;

    @Override
    void notifyLotFull(ParkingLot parkingLot) {
        isNotifiedFull = true;
    }

    @Override
    void notifyLotFree(ParkingLot parkingLot) {
        isNotifiedFree = true;
    }
}