package src;

import java.util.ArrayList;

import static java.lang.String.valueOf;


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
    ArrayList<String> openMeters = new ArrayList<>();

    /**
     *
     * @param parkingMeterNumber
     * @param parkingMeterLocation
     * @param timeAtMeter
     */
    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, String timeAtMeter) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1 || !timeAtMeter.matches("^(\\d|0\\d|1\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterLocation = parkingMeterLocation;
        this.timeAtMeter = timeAtMeter;
        this.meterIsTaken = false;
        this.parkingMeterNumber = parkingMeterNumber;
        meterStorage = new MeterStorage(this.parkingMeterNumber, this.parkingMeterLocation, this.timeAtMeter, false);
    }

    /**
     *
     * @return the time at the meter
     */
    public String getTimeAtMeter() {
        return this.timeAtMeter;
    }

    /**
     *
     * @return the parking meter location
     */
    public String getParkingMeterLocation() {
        return this.parkingMeterLocation;
    }

    /**
     * set the meter as taken when someone takes it
     * @param key
     * @param meterIsTaken setter
     */
    public void setMeterIsTaken(Integer key, Boolean meterIsTaken) {
        this.meterIsTaken = meterIsTaken;
        meterStorage.getHm().replace(this.parkingMeterNumber, new String[]{this.parkingMeterLocation, this.timeAtMeter, valueOf(this.meterIsTaken)});
    }

    /**
     *
     * @return if the meter is taken
     */
    public Boolean getMeterIsTaken() {
        return this.meterIsTaken;
    }

    /**
     *
     * @return the parking meter number
     */
    public Integer getParkingMeterNumber() {
        return parkingMeterNumber;
    }

    /**
     * Set the meter as open
     * @param parkingMeter
     * add it to the list of open meters
     */
    public void setOpenMeter(ParkingMeter parkingMeter) {
        if (parkingMeter.getMeterIsTaken() == false) {
            openMeters.add(valueOf(parkingMeter));
        }
    }

    /**
     *
     * @return openMeters if there are open meters
     */
    public ArrayList<String> getOpenMeters() {
        if (openMeters.size() > 0) {
            return openMeters;
        }
        return null;
    }
}
