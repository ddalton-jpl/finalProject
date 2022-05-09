package tests;

import org.junit.jupiter.api.Test;
import src.ParkingMeter;

import java.util.ArrayList;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingMeterTest {

    Integer parkingMeterNumber = 123456;
    String parkingMeterLocation = "8809 W Castle Street";
    String parkingMeterTime = "10:40";
    ParkingMeter parkingMeter = new ParkingMeter(parkingMeterNumber, parkingMeterLocation, parkingMeterTime, false);

    ArrayList<String> openMeters = new ArrayList<>();

    @Test
    void ParkingMeterConstructor() {
        assertEquals(parkingMeterLocation, parkingMeter.getParkingMeterLocation());
        assertEquals(parkingMeterTime, parkingMeter.getTimeAtMeter());
    }

    @Test
    void constructorException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Integer invalidParkingMeterNumber = 123;
            String invalidParkingMeterLocation = "";
            String invalidParkingMeterTime = "99:99";
            new ParkingMeter(invalidParkingMeterNumber, invalidParkingMeterLocation, invalidParkingMeterTime, false);
        });
        String expectedMessage = "Invalid Input";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getParkingMeterTime() {
        assertEquals(parkingMeterTime, parkingMeter.getTimeAtMeter());
    }

    @Test
    void getParkingMeterLocation() {
        assertEquals(parkingMeterLocation, parkingMeter.getParkingMeterLocation());
    }

    @Test
    void getMeterIsTaken() {
        parkingMeter.setMeterIsTaken(true);
        assertEquals(true, parkingMeter.getMeterIsTaken());
    }

    @Test
    void setMeterIsTaken() {
        parkingMeter.setMeterIsTaken(false);
        assertEquals(false, parkingMeter.getMeterIsTaken());
    }

    @Test
    void getOpenMeter() {
        parkingMeter.setMeterIsTaken(false);
        parkingMeter.setOpenMeter(parkingMeter);
        openMeters.add(parkingMeter.getOpenMeters().toString());
        assertEquals(openMeters.get(0), parkingMeter.getOpenMeters().toString() );
    }

}