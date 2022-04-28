public class ParkingMeter {
    // 6-digit Identification # for a parking meter
    private final Integer parkingMeterNumber;

    // The location of the parking meter
    private final String parkingMeterLocation;

    // The duration you can park at a meter
    private final String parkingMeterTime;

    // Constructor for the parking meter
    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, String parkingMeterTime) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !parkingMeterTime.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterNumber = parkingMeterNumber;
        this.parkingMeterLocation = parkingMeterLocation;
        this.parkingMeterTime = parkingMeterTime;
    }

    public String getParkingMeterTime() {
        return parkingMeterTime;
    }

    public String getParkingMeterLocation() {
        return parkingMeterLocation;
    }

    public Integer getParkingMeterNumber() {
        return parkingMeterNumber;
    }
}
