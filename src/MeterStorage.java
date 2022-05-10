package src;

import java.util.HashMap;

public class MeterStorage {
    // Hashmap for parking meter
    private final HashMap<Integer, String[]> hm = new HashMap<>();

    public MeterStorage(ParkingMeter parkingMeter) {
        if (parkingMeter.getParkingMeterNumber() > 999999 || parkingMeter.getParkingMeterNumber() < 100000 || parkingMeter.getParkingMeterLocation().length() < 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
        hm.put(parkingMeter.getParkingMeterNumber(), new String[]{parkingMeter.getParkingMeterLocation(), String.valueOf(parkingMeter.getMeterIsTaken())});
    }

    public HashMap<Integer, String[]> getHm() {
        return hm;
    }

    public String getParkingMeterLocation(Integer key) {
        if (key > 999999 || key < 100000) {
            throw new IllegalArgumentException("Invalid input");
        }
        return hm.get(key)[0];
    }

    public String getParkingMeterTime(Integer key) {
        if (key > 999999 || key < 100000) {
            throw new IllegalArgumentException("Invalid input");
        }
        return hm.get(key)[1];
    }
}
