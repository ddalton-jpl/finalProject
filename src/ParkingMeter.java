package src;

public class ParkingMeter {
    // TODO Store these parking meters in a hash map by hashing the parking meter #
    // TODO only add parking meter if it is not already in the hashmap
    // 6-digit Identification # for a parking meter
    private final Integer parkingMeterNumber;

    // The location of the parking meter
    private final String parkingMeterLocation;

    // The duration you can park at a meter
    private final String timeAtMeter;

    // Constructor for the parking meter
    private Boolean meterIsTaken;

    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, String parkingMeterTime) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !parkingMeterTime.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterNumber = parkingMeterNumber;
        this.parkingMeterLocation = parkingMeterLocation;
        this.timeAtMeter = parkingMeterTime;
        this.meterIsTaken = false;

    }

    public String getTimeAtMeter() {
        return timeAtMeter;
    }

    public String getParkingMeterLocation() {
        return parkingMeterLocation;
    }

    public void setMeterIsTaken(Boolean meterIsTaken) {
        this.meterIsTaken = meterIsTaken;
    }

    public Boolean getMeterIsTaken() {
        return this.meterIsTaken;
    }

    public Integer getParkingMeterNumber() {
        return parkingMeterNumber;
    }
}
