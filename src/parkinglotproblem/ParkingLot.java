package parkinglotproblem;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {

    private Map<Integer, Car> parkedCars;
    private int size;
    private String name;
    private ParkingLotAttendant attendant;
    private Integer lastToken;

    ParkingLot(int size, String name) {
        this.size = size;
        this.name = name;
        this.parkedCars = new HashMap<>();
        this.lastToken = 0;
    }

    Integer park(Car car) {
        if (isFull()) return null;
        Integer token = ++lastToken;
        parkedCars.put(token, car);

        if(!isAttendantPresent()) return token;

        this.attendant.updateDisplay(this.name, this.getCarsCount());

        if (isFull()) {
            attendant.notifyLotFull(this);
        }

        return token;
    }

    private boolean isAttendantPresent() {
        return attendant != null;
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

        if(!isAttendantPresent()){
            return true;
        }

        this.attendant.updateDisplay(this.name, this.getCarsCount());
        return true;
    }

    private Integer getCarsCount() {
        return this.parkedCars.size();
    }
}
