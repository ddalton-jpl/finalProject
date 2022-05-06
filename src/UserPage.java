package src;

public class UserPage {

    private boolean hasParkingSession;
    private String timeRemaining;
    private String location;

    public UserPage(boolean hasParkingSession) {
        if (hasParkingSession == true) {
            this.timeRemaining = "0";
            this.location = "N/A";
        }
    }



    private void setTimeRemaining(ParkingMeter meter) {
        timeRemaining = meter.getTimeAtMeter();
    }


}
