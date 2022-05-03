package src;

public class ParkingMeter {

    // The location of the parking meter
    private final String parkingMeterLocation;

    // The duration you can park at a meter
    private final String timeAtMeter;
    private final Integer parkingMeterNumber;

    // Constructor for the parking meter
    private Boolean meterIsTaken;

    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, String timeAtMeter) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !timeAtMeter.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterLocation = parkingMeterLocation;
        this.timeAtMeter = timeAtMeter;
        this.meterIsTaken = false;
        this.parkingMeterNumber = parkingMeterNumber;
        new MeterStorage(this.parkingMeterNumber, this.parkingMeterLocation, this.timeAtMeter);
    }

    public String getTimeAtMeter() {
        return this.timeAtMeter;
    }

    public String getParkingMeterLocation() {
        return this.parkingMeterLocation;
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
