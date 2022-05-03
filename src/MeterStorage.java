package src;

import java.util.HashMap;

public class MeterStorage {
    // Hashmap for parking meter
    private final HashMap<Integer, String[]> hm = new HashMap<>();

    Integer parkingMeterNumber;

    String parkingMeterLocation;

    String parkingMeterTime;

    public MeterStorage(Integer parkingMeterNumber, String parkingMeterLocation, String parkingMeterTime) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !parkingMeterTime.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterNumber = parkingMeterNumber;
        this.parkingMeterLocation = parkingMeterLocation;
        this.parkingMeterTime = parkingMeterTime;
        hm.put(this.parkingMeterNumber, new String[]{this.parkingMeterLocation, this.parkingMeterTime});
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
            throw new IllegalArgumentException("Invalid Input");
        }
        return hm.get(key)[1];
    }
}
