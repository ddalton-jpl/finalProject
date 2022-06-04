package src;
import src.ParkingMeter;
public class Form {

    private int time;
    private int num;
    String location;

    /**
     *
     * @param num set as num
     * @param time set as time
     * @param location set as location
     * The form tab will interact with the GUI,
     * taking the user input and storing it inside a user object
     *
     * The user input:
     * Please enter meter number
     * Please enter meter time
     * Please enter meter location
     */
    public Form(int num, int time, String location) {
        this.num = num;
        this.time = time;
        this.location = location;
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
     * @return the time
     */
    public int getTime() {
        return this.time;
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
    public int setNum(int n) {
        this.num = n;
        return n;
    }

    /**
     * set the time
     * @param t is time
     * @return t the time
     */
    public int setTime(int t) {
        this.time = t;
        return t;
    }

    /**
     * Set the location
     * @param loc being location
     * @return loc
     */
    public String setLocation(String loc) {
        this.location = loc;
        return loc;
    }

    /**
     * Check is the meter is taken
     * @param num being meter number
     * @return true if meter is taken
     * else, return false
     */
    public boolean isTaken(Integer num) {

        if (num >= 999999 || num <= 100000 ) {
            throw new IllegalArgumentException();
        }
        if(!meterStorage.getHm.get(num).getMeterIsTaken())
            return false;

        return true;
    }
}
