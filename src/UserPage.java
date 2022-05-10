package src;

public class UserPage {
    private User user;

    public UserPage(User user) {
        this.user = user;
    }

    private String getTimer(ParkingMeter meter) {
        if (meter == null)
            System.out.println("Display blank");
        return user.getMeter().timeAtMeter;
    }

    private String getLocation(ParkingMeter meter) {
        if (meter == null)
            System.out.println("No parking session");
        return user.getMeter().parkingMeterLocation;
    }


}
