package src;
import src.ParkingMeter;
public class Form {

    private boolean isTaken;
    private int num;
    private String location;

    /**
     *
     * @param meter is the meter passed to the form object
     * The form tab will interact with the GUI,
     * taking the user input and storing it inside a user object
     *
     * The user input:
     * Please enter meter number
     * Please enter meter time
     * Please enter meter location
     */
    public Form(ParkingMeter meter) {
        this.num = meter.getParkingMeterNumber();
        this.isTaken = meter.getMeterIsTaken();
        this.location = meter.getParkingMeterLocation();
    }

    /**
     *
     * @return num
     */
    public int getNum() {
        return this.num;
    }


    /**
     *
     * @return the location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Set the num
     * @param n number
     * @return number
     */
    public void setNum(int n) {
        this.num = n;
    }


    /**
     * Set the location
     * @param loc being location
     * @return loc
     */
    public void setLocation(String loc) {
        this.location = loc;
    }

    /**
     * Check is the meter is taken
     * @return true if meter is taken
     * else, return false
     */
    public boolean isTaken() {
        return this.isTaken;
    }

    /**
     * set the isTaken status
     * @param isTaken is the new
     * status of the meter
     */
    public void setIsTaken(boolean isTaken){
        this.isTaken = isTaken;
    }
}
