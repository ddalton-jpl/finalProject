package src;

public class parkingAppMain {
    public static void main(String[] args) {
        // Creating Some dummy parking meters
        ParkingMeter parkingMeter1 = new ParkingMeter(123456, "2105 PowerPoint ave", false);
        ParkingMeter parkingMeter2 = new ParkingMeter(654321, "8805 Electric ave", false);
        ParkingMeter parkingMeter3 = new ParkingMeter(513351, "4431 Silly rd", false);
        ParkingMeter parkingMeter4 = new ParkingMeter(437563, "4124 Harrison St", false);
        ParkingMeter parkingMeter5 = new ParkingMeter(758475, "3302 Thompson ave", false);
        ParkingMeter parkingMeter6 = new ParkingMeter(339587, "1322 Blain rd", false);
        ParkingMeter parkingMeter7 = new ParkingMeter(100294, "5454 Franklin St", false);
        ParkingMeter parkingMeter8 = new ParkingMeter(229485, "9990 Jackson ave", false);
        ParkingMeter parkingMeter9 = new ParkingMeter(102954, "3215 Everest rd", false);
        ParkingMeter parkingMeter10 = new ParkingMeter(204594, "6785 Main St", false);

        parkingMeter1.addMeter();
        parkingMeter2.addMeter();
        parkingMeter3.addMeter();
        parkingMeter4.addMeter();
        parkingMeter5.addMeter();
        parkingMeter6.addMeter();
        parkingMeter7.addMeter();
        parkingMeter8.addMeter();
        parkingMeter9.addMeter();
        parkingMeter10.addMeter();


        // Storing dummy parking meters
        // TODO may need to let meterStorage accept an array of Parking Meters
        MeterStorage meterStorage1 = new MeterStorage(parkingMeter1);
        MeterStorage meterStorage2 = new MeterStorage(parkingMeter2);
        MeterStorage meterStorage3 = new MeterStorage(parkingMeter3);

        new parkingGUI();



    }
}
