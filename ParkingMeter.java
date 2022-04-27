public class ParkingMeter {
    // 6-digit Identification # for a parking meter
    private Integer parkingMeterNumber;

    // The location of the parking meter
    private String parkingMeterLocation;

    // The duration you can park at a meter
    private String parkingMeterTime;

    // Constructor for the parking meter
    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, Integer parkingMeterTime) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
    }
}
