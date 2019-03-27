package parkinglotproblem;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {

    private Map<Integer, Car> parkedCars;
    private int size;
    private ParkingLotAttendant attendant;
    private Integer lastToken;

    ParkingLot(int size) {
        this.size = size;
        this.parkedCars = new HashMap<>();
        this.lastToken = 0;
    }

    Integer park(Car car) {
        if (isFull()) return null;
        Integer token = ++lastToken;
        parkedCars.put(token, car);
        if (isFull() && attendant != null) {
            attendant.notifyLotFull(this);
        }
        return token;
    }

    void registerAttendant(ParkingLotAttendant attendant) {
        this.attendant = attendant;
    }

    boolean isFull() {
        return size == parkedCars.size();
    }

    boolean unPark(Integer token) {
        if (!parkedCars.containsKey(token)) return false;
        if (isFull()) attendant.notifyLotFree(this);
        parkedCars.remove(token);
        return true;
    }
}
