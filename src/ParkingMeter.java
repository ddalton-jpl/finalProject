package src;

import java.util.HashMap;

public class ParkingMeter {

    // The location of the parking meter
    private final String parkingMeterLocation;

    // The duration you can park at a meter
    private final String timeAtMeter;
    private final Integer parkingMeterNumber;

    // Constructor for the parking meter
    private Boolean meterIsTaken;

    // Hashmap for parking meter
    private HashMap<Integer, ParkingMeter> hm = new HashMap<>();;

    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, String parkingMeterTime) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !parkingMeterTime.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$") || hm.containsKey(parkingMeterNumber)) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterLocation = parkingMeterLocation;
        this.timeAtMeter = parkingMeterTime;
        this.meterIsTaken = false;
        this.parkingMeterNumber = parkingMeterNumber;
        hm.put(this.parkingMeterNumber, this);
    }

    public HashMap<Integer, ParkingMeter> getHm() {
        return hm;
    }

    public String getTimeAtMeter(Integer key) {
        return hm.get(key).timeAtMeter;
    }

    public String getParkingMeterLocation(Integer key) {
        return hm.get(key).parkingMeterLocation;
    }

    public void setMeterIsTaken(Boolean meterIsTaken, Integer key) {
        hm.get(key).meterIsTaken = meterIsTaken;
    }

    public Boolean getMeterIsTaken(Integer key) {
        return hm.get(key).meterIsTaken;
    }

    public Integer getParkingMeterNumber() {
        return parkingMeterNumber;
    }
}
