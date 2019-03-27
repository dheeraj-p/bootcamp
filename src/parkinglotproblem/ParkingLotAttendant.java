package parkinglotproblem;

class ParkingLotAttendant {

    private ParkingLotAssistant assistant;

    public ParkingLotAttendant(ParkingLotAssistant assistant) {
        this.assistant = assistant;
    }

    void notifyLotFull(ParkingLot parkingLot) {
        System.out.println("Notified parking lot full");
    }

    void notifyLotFree(ParkingLot parkingLot) {
        System.out.println("Notified parking lot free");
    }

    void updateDisplay(String parkingLotName, int numberOfCars) {
        this.assistant.updateDisplay(parkingLotName, numberOfCars);
    }
}
