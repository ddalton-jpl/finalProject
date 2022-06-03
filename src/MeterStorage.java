package src;

import java.util.HashMap;

/**
 * The storage for parking meters. This class will allow meters to be stored
 * in a HashMap and have their information called upon when necessary.
 */

public class MeterStorage {
    /**
     * The HashMap that stores Parking Meters.
     * Meters will be stored by key. They will also contain a record of the meter's location and whether it is currently reserved.
     */
    private final HashMap<Integer, String[]> hm = new HashMap<>();

    /**
     * This will create a new meter storage to store a Parking Meter object.
     * The parking meter will be added to the hashmap with its associated key and location.
     *
     * @param parkingMeter A parking meter to be added to the MeterStorage
     * @throws IllegalArgumentException If parking meter number exceeds 999999, or if parking meter number is less than 100000, or if the location of the parking meter is incorrect.
     */
    public MeterStorage(ParkingMeter parkingMeter) {
        if (parkingMeter.getParkingMeterNumber() > 999999 || parkingMeter.getParkingMeterNumber() < 100000 || parkingMeter.getParkingMeterLocation().length() < 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
        hm.put(parkingMeter.getParkingMeterNumber(), new String[]{parkingMeter.getParkingMeterLocation(), String.valueOf(parkingMeter.getMeterIsTaken())});
    }

    /**
     * This will return the current HashMap for the MeterStorage class.
     *
     * @return The HashMap stored in MeterStorage
     */
    public HashMap<Integer, String[]> getHm() {
        return hm;
    }

    /**
     * This will take in a key associated with one parking meter and return its current location.
     *
     * @param key A key associated with the desired ParkingMeter
     * @return Parking Meter location
     * @see ParkingMeter
     */
    public String getParkingMeterLocation(Integer key) {
        if (key > 999999 || key < 100000) {
            throw new IllegalArgumentException("Invalid input");
        }
        return hm.get(key)[0];
    }

    /**
     * This will take in a key associated with one parking meter and return the time remaining on the meter.
     *
     * @param key A key associated with the desired ParkingMeter
     * @return Time left on meter
     * @see ParkingMeter
     */
    public String getParkingMeterTime(Integer key) {
        if (key > 999999 || key < 100000) {
            throw new IllegalArgumentException("Invalid input");
        }
        return hm.get(key)[1];
    }
}
