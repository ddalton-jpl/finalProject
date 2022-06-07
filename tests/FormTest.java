package tests;
import src.Form;
import src.ParkingMeter;
import org.junit.jupiter.api.Test;
import src.MeterStorage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormTest {
    int num = 123456;
    String loc = "231 Benton St";

    ParkingMeter meter = new ParkingMeter(num, loc,false);


    @Test
    void getNumTest(){
        assertEquals(num, meter.getParkingMeterNumber());
    }

    @Test
    void getLocationTest(){
        assertEquals(loc, meter.getParkingMeterLocation());
    }

    @Test
    void isTakenTest(){
        meter.setMeterIsTaken(num, false);

        assertEquals(false, meter.getMeterIsTaken());
    }

}


