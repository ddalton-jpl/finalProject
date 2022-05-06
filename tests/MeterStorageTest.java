/*
    This is the source of data force the parking meter classes. This can be considered as part of a database
    where information can be stored and altered if needed
 */

package tests;

import org.junit.jupiter.api.Test;
import src.MeterStorage;
import src.ParkingMeter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MeterStorageTest {
    // Key for parking meter storage map
    Integer parkingMeterNumber = 123456;

    // location of parking meter
    String parkingMeterLocation = "8809 W Castle Street";

    // time remaining on meter
    String parkingMeterTime = "10:40";

    // parking meter object
    ParkingMeter parkingMeter = new ParkingMeter(parkingMeterNumber, parkingMeterLocation, parkingMeterTime, false);

    // meter storage object creation
    MeterStorage meterStorage = new MeterStorage(parkingMeter);

    String[] hmTestValues = new String[]{parkingMeterLocation, parkingMeterTime, String.valueOf(false)};

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
            ParkingMeter parkingMeter1 = new ParkingMeter(invalidParkingMeterNumber, invalidParkingMeterLocation, invalidParkingMeterTime, false);
            new MeterStorage(parkingMeter1);
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

    @Test
    void getParkingMeterLocationException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Integer invalidParkingMeterNumber = 123;
            meterStorage.getParkingMeterLocation(invalidParkingMeterNumber);
        });
        String expectedMessage = "Invalid input";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getParkingMeterTime() {
        assertEquals(parkingMeterTime, meterStorage.getParkingMeterTime(parkingMeterNumber));
    }

    @Test
    void getParkingMeterTimeException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Integer invalidParkingMeterNumber = 123;
            meterStorage.getParkingMeterTime(invalidParkingMeterNumber);
        });
        String expectedMessage = "Invalid input";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}