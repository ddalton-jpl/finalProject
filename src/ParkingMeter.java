package src;

import java.util.ArrayList;

public class ParkingMeter {

    // The location of the parking meter
    private final String parkingMeterLocation;

    // The duration you can park at a meter
    private final String timeAtMeter;
    private final Integer parkingMeterNumber;

    // Constructor for the parking meter
    private Boolean meterIsTaken;

    // Hashmap of taken parking meters
    MeterStorage meterStorage;

    // List of open parking meters
    ArrayList<String> openMeters;

    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, String timeAtMeter) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !timeAtMeter.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterLocation = parkingMeterLocation;
        this.timeAtMeter = timeAtMeter;
        this.meterIsTaken = false;
        this.parkingMeterNumber = parkingMeterNumber;
        new MeterStorage(this.parkingMeterNumber, this.parkingMeterLocation, this.timeAtMeter, false);
    }

    public String getTimeAtMeter() {
        return this.timeAtMeter;
    }

    public String getParkingMeterLocation() {
        return this.parkingMeterLocation;
    }

    public void setMeterIsTaken(Integer key, Boolean meterIsTaken) {
        this.meterIsTaken = meterIsTaken;
        meterStorage.getHm().put(key, new String[]{this.parkingMeterLocation, this.timeAtMeter, String.valueOf(this.meterIsTaken)});
    }

    public Boolean getMeterIsTaken() {
        return this.meterIsTaken;
    }

    public Integer getParkingMeterNumber() {
        return parkingMeterNumber;
    }

    public void setOpenMeter() {
        if (!this.meterIsTaken) {
            openMeters.add(String.valueOf(this));
        }
    }

    public ArrayList<String> getOpenMeters() {
        return openMeters;
    }
}
