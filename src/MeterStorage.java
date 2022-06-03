package src;

import java.util.HashMap;

public class MeterStorage {
    /**
     * The HashMap that stores Parking Meters.
     */
    private final HashMap<Integer, String[]> hm = new HashMap<>();

    /**
     * This will create a new meter storage to store a Parking Meter object.
     *
     * @param parkingMeter
     * @throws IllegalArgumentException If parking meter number exceeds 999999, or if parking meter number is less than 100000, or if the location of the parking meter is incorrect.
     */
    public MeterStorage(ParkingMeter parkingMeter) {
        if (parkingMeter.getParkingMeterNumber() > 999999 || parkingMeter.getParkingMeterNumber() < 100000 || parkingMeter.getParkingMeterLocation().length() < 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
        hm.put(parkingMeter.getParkingMeterNumber(), new String[]{parkingMeter.getParkingMeterLocation(), String.valueOf(parkingMeter.getMeterIsTaken())});
    }

    /**
     * This will return the current HashMap for
     * @return hm
     */
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
