package src;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class ParkingMeter {

    // The location of the parking meter
    private String parkingMeterLocation;

    // The duration you can park at a meter
    private String timeAtMeter;
    private final Integer parkingMeterNumber;

    // Constructor for the parking meter
    private Boolean meterIsTaken;

    // Hashmap of taken parking meters
    MeterStorage meterStorage;

    // List of open parking meters
    ArrayList<String> openMeters = new ArrayList<>();

    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, String timeAtMeter, Boolean meterIsTaken) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !timeAtMeter.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterLocation = parkingMeterLocation;
        this.timeAtMeter = timeAtMeter;
        this.meterIsTaken = meterIsTaken;
        this.parkingMeterNumber = parkingMeterNumber;
        meterStorage = new MeterStorage(this);
    }

    public String getTimeAtMeter() {
        return this.timeAtMeter;
    }

    public void setTimeAtMeter(String timeChosen) {
        this.timeAtMeter = timeChosen;
    }

    public String getParkingMeterLocation() {
        return this.parkingMeterLocation;
    }

    public void setParkingMeterLocation(String location) {
        this.parkingMeterLocation = location;
    }

    public void setMeterIsTaken(Boolean meterIsTaken) {
        this.meterIsTaken = meterIsTaken;
        meterStorage.getHm().replace(this.parkingMeterNumber, new String[]{this.parkingMeterLocation, this.timeAtMeter, valueOf(this.meterIsTaken)});
    }

    public Boolean getMeterIsTaken() {
        return this.meterIsTaken;
    }

    public Integer getParkingMeterNumber() {
        return parkingMeterNumber;
    }

    public void setOpenMeter(ParkingMeter parkingMeter) {
        if (!parkingMeter.getMeterIsTaken()) {
            openMeters.add(valueOf(parkingMeter));
        }
    }

    public ArrayList<String> getOpenMeters() {
        if (openMeters.size() > 0) {
            return openMeters;
        }
        return null;
    }
}
