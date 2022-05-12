package src;

public class parkingAppMain {
    public static void main(String[] args) {
        // Creating Some dummy parking meters
        ParkingMeter parkingMeter1 = new ParkingMeter(123456, "2105 PowerPoint ave", false);
        ParkingMeter parkingMeter2 = new ParkingMeter(654321, "8805 Electric ave", false);
        ParkingMeter parkingMeter3 = new ParkingMeter(513351, "4431 Silly rd", false);

        parkingMeter1.addMeter();
        parkingMeter2.addMeter();
        parkingMeter3.addMeter();

        // Storing dummy parking meters
        // TODO may need to let meterStorage accept an array of Parking Meters
        MeterStorage meterStorage1 = new MeterStorage(parkingMeter1);
        MeterStorage meterStorage2 = new MeterStorage(parkingMeter2);
        MeterStorage meterStorage3 = new MeterStorage(parkingMeter3);

        new JTabbed_Logic();



    }
}
