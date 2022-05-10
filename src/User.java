package src;

public class User {

    private String name;
    public ParkingMeter meter;
    private boolean hasSession;

    public User(String name, ParkingMeter meter) {
        if (meter == null)
            this.name = name;
            System.out.println("No parking session");
        else {
            this.name = name;
            this.meter = meter;
            this.hasSession = true;
        }

    }

    public ParkingMeter getMeter() {
        return meter;
    }

    public String getName() {
        return name;
    }

    public void setMeter(ParkingMeter meter) {
        this.meter = meter;
    }

    public void setName(String name) {
        this.name = name;
    }


}
