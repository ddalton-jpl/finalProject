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
    public static ArrayList<ParkingMeter> availableMeters;

    /**
     *
     * @param parkingMeterNumber
     * @param parkingMeterLocation
     * @param isMeterTaken
     */
    public ParkingMeter(Integer parkingMeterNumber, String parkingMeterLocation, boolean isMeterTaken) {
        if (parkingMeterNumber > 999999 || parkingMeterNumber < 100000 || parkingMeterLocation.length() < 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.parkingMeterLocation = parkingMeterLocation;
        this.meterIsTaken = meterIsTaken;
        this.parkingMeterNumber = parkingMeterNumber;
        meterStorage = new MeterStorage(this);
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

    public void setParkingMeterLocation(String location) {
        this.parkingMeterLocation = location;
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

    public void addMeter(){
        if(availableMeters == null){
            availableMeters = new ArrayList<>();
        }
        availableMeters.add(this);
    }


}
