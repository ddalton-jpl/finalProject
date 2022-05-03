package tests;

import org.junit.jupiter.api.Test;
import src.MeterStorage;

import java.util.Arrays;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MeterStorageTest {
    // Key for parking meter storage map
    Integer parkingMeterNumber = 123456;

    // location of parking meter
    String parkingMeterLocation = "8809 W Castle Street";

    // time remaining on meter
    String parkingMeterTime = "10:40";

    // meter object
    MeterStorage meterStorage = new MeterStorage(parkingMeterNumber, parkingMeterLocation, parkingMeterTime);

    String[] hmTestValues = new String[]{parkingMeterLocation, parkingMeterTime};

    @Test
    void ParkingMeterConstructor() {
        assertEquals(parkingMeterLocation, meterStorage.getParkingMeterLocation(parkingMeterNumber));
        assertEquals(parkingMeterTime, meterStorage.getParkingMeterTime(parkingMeterNumber));
    }

    @Test
    void constructorException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Integer invalidParkingMeterNumber = 123;
            String invalidParkingMeterLocation = "";
            String invalidParkingMeterTime = "99:99";
            new MeterStorage(invalidParkingMeterNumber, invalidParkingMeterLocation, invalidParkingMeterTime);
        });
        String expectedMessage = "Invalid Input";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getHmTest() {
        assertEquals(Arrays.toString(hmTestValues), Arrays.toString(meterStorage.getHm().get(parkingMeterNumber)));
    }

    @Test
    void getParkingMeterLocation() {
        assertEquals(parkingMeterLocation, meterStorage.getParkingMeterLocation(parkingMeterNumber));
    }

}