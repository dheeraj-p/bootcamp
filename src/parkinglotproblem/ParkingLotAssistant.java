package parkinglotproblem;

class ParkingLotAssistant {
    void updateDisplay(String parkingLotName, Integer numberOfCars) {
        ParkingLotDisplay.getInstance().update(parkingLotName, numberOfCars);

    }
}
