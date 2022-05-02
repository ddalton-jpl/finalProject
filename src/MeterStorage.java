package src;

import java.util.HashMap;

public class MeterStorage extends ParkingMeter{
    // Hashmap for parking meter
    private HashMap<Integer, ParkingMeter> hm = new HashMap<>();

    public MeterStorage(Integer parkingMeterNumber, String parkingMeterLocation, String parkingMeterTime) {
        super(parkingMeterNumber, parkingMeterLocation, parkingMeterTime);
    }

    public void setHm(MeterStorage meterStorage) {
        hm.put(getParkingMeterNumber(), meterStorage);
    }

    public HashMap<Integer, ParkingMeter> getHm() {
            return hm;
        }
    }
