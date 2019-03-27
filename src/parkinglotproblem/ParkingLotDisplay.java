package parkinglotproblem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

class ParkingLotDisplay {

    private Map<String, Integer> details;
    private static ParkingLotDisplay parkingLotDisplay;

    private ParkingLotDisplay() {
        this.details = new LinkedHashMap<>();
    }

    void update(String parkingLotName, int numberOfCars) {
        this.details.put(parkingLotName, numberOfCars);
    }

    static ParkingLotDisplay getInstance(){
        if(parkingLotDisplay == null){
            parkingLotDisplay = new ParkingLotDisplay();
        }
        return parkingLotDisplay;
    }

    @Override
    public boolean equals(Object otherParkingLotDetails) {
        if (this == otherParkingLotDetails) return true;
        if (otherParkingLotDetails == null || getClass() != otherParkingLotDetails.getClass()) return false;
        ParkingLotDisplay that = (ParkingLotDisplay) otherParkingLotDetails;
        return Objects.equals(details, that.details);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String delimiter = "";

        for (Map.Entry<String, Integer> detail : this.details.entrySet()) {
            result.append(delimiter).append(detail.getKey()).append('\t').append(detail.getValue());
            delimiter = "\n";
        }
        return result.toString();
    }
}
