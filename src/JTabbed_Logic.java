package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Objects;

import static src.ParkingMeter.availableMeters;

public class JTabbed_Logic extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel User;
    private JPanel Parking;
    private JLabel TimeRemaining;
    private JPanel Form;
    private JLabel PlzEtrNum;
    private JTextField meterNum;
    private JButton parkingFormSubmitButton;
    private JLabel TimerLabel;
    private JLabel userCurrentLocation;
    private JButton parkingFormClearButton;
    private JSlider hourSlider;
    private JSlider minuteSlider;
    private JLabel hoursLabelOnFormTab;
    private JLabel minutesLabelOnFormTab;
    private JTable parkingTable;


    private String[] columns = {"Location:", "Meter-Number:"};
    public static String[][] data = new String[10][2];


    //variables and tools for the timer
    private Timer parkingTimer;
    private Integer second, minute, hour;
    private String ddSecond, ddMinute, ddHour;
    DecimalFormat DFormat =new DecimalFormat("00");

    //temporary ParkingMeter parameters to store currently in use meter and to be able to return it to the list once the timer runs out
    private Integer tempNumber;
    private String tempLocation;
    private Boolean tempIsTaken;

    public JTabbed_Logic() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the close operation to when the "red X" is clicked.
        this.setSize(new Dimension(500,500));    // sets the size of the window to 500 by 500 pixels.
        this.setLocationRelativeTo(null);                    //  Sets the starting location to the center of the screen.
        this.add(tabbedPane1);// adds the JTabbedPane Object to the JFrame.
        this.setTitle("Smart-park!");// sets the title of the application.
        ImageIcon image = new ImageIcon("parkingSign.png");
        this.setIconImage(image.getImage());
        createTable();
        this.parkingFormSubmitButton.addActionListener(this); // creates the action listener that allows the button to function when clicked.
        this.parkingFormClearButton.addActionListener(this);
        this.setVisible(true);// makes the JFrame visible.
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == parkingFormSubmitButton){
            for(ParkingMeter p : availableMeters){
                if(meterNum.getText().isBlank() || meterNum.getText().isEmpty()){
                    meterNum.setText("");
                    return;
                }
                else if(Objects.equals(p.getParkingMeterNumber(), Integer.valueOf(meterNum.getText()))){
                    tempIsTaken = p.getMeterIsTaken();
                    tempLocation = p.getParkingMeterLocation();
                    tempNumber = p.getParkingMeterNumber();
                    String str = p.getParkingMeterLocation();
                    userCurrentLocation.setText(str);
                    second = 0;
                    minute = minuteSlider.getValue();
                    hour = hourSlider.getValue();
                    timer();
                    parkingTimer.start();
                    availableMeters.remove(p);
                    meterNum.setText("");
                    return;
                }
            }
            meterNum.setText("");
            JOptionPane.showMessageDialog(null, "The meter you're looking for is currently in use.", "No Meter Found", JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == parkingFormClearButton){
            meterNum.setText("");
        }

    }

    public void timer() {
        parkingTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hour == 0 && minute == 0 && second == 0){
                    parkingTimer.stop();
                    new ParkingMeter(tempNumber,tempLocation,tempIsTaken).addMeter();
                    userCurrentLocation.setText("*No meter reserved*");
                    JOptionPane.showMessageDialog(null, "The time on your meter has expired!", "Time Is Up", JOptionPane.WARNING_MESSAGE);

                }
                second--;
                ddSecond = DFormat.format(second);
                ddMinute = DFormat.format(minute);
                ddHour = DFormat.format(hour);
                TimerLabel.setText(ddHour + " : " + ddMinute + " : " + ddSecond);
                if(second == -1){
                    second = 59;
                    minute--;
                    ddSecond = DFormat.format(second);
                    ddMinute = DFormat.format(minute);
                    ddHour = DFormat.format(hour);
                    TimerLabel.setText(ddHour + " : " + ddMinute + " : " + ddSecond);
                }
                if(minute == -1){
                    minute = 59;
                    hour--;
                    ddSecond = DFormat.format(second);
                    ddMinute = DFormat.format(minute);
                    ddHour = DFormat.format(hour);
                    TimerLabel.setText(ddHour + " : " + ddMinute + " : " + ddSecond);
                }

            }
        });
    }

    public void createTable(){
        int i = 0;
        String[][] newData = new String[availableMeters.size()][2];
        for(ParkingMeter p : availableMeters){
            newData[i][0] = p.getParkingMeterLocation();
            newData[i][1] = String.valueOf(p.getParkingMeterNumber());
            i++;
        }
        this.parkingTable = new JTable(newData, columns); // 1D array(columns) sets the title of each column, the 2D array(data) sets the data in the table.
        this.parkingTable.setPreferredScrollableViewportSize(new Dimension(400,400)); // sets the preferred size of the table.
        this.parkingTable.setEnabled(false);  // makes it so that the data in the data table cannot be edited by the user. (As in changing Address names or time remaining)
        JScrollPane scroller = new JScrollPane(parkingTable); // makes the table scrollable if the number of locations is greater than what can fit on the page.
        this.Parking.add(scroller); // adds the scrolling table to the "Parking" Panel.
    }
}
