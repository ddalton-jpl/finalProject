package ParkingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTabbed_Logic extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel User;
    private JPanel Parking;
    private JLabel TimeRemaining;
    private JPanel Form;
    private JLabel PlzEtrNum;
    private JTextField meterNum;
    private JButton Submit;
    private JTable parkingTable;
    private ImageIcon image = new ImageIcon("parkingSign.png");

    public JTabbed_Logic() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the close operation to when the "red X" is clicked.
        this.setSize(new Dimension(500,500));    // sets the size of the window to 500 by 500 pixels.
        this.setLocationRelativeTo(null);                    //  Sets the starting location to the center of the screen.
        this.add(tabbedPane1);// adds the JTabbedPane Object to the JFrame.
        this.setTitle("Smart City Parking");// sets the title of the application.
        this.setIconImage(image.getImage());



        String[] columns = {"Location:", "Time Remaining:"};
        String[][] data = {{"Meter 1", "45:53"}, {"Meter 2", "59:12"}, {"Meter 3", "34:41"}};
        parkingTable = new JTable(data, columns); // 1D array sets the title of each column, the 2D array sets the data in the table.
        parkingTable.setPreferredScrollableViewportSize(new Dimension(400,400)); // sets the preferred size of the table.
        parkingTable.setEnabled(false);  // makes it so that the data in the data table cannot be edited by the user. (As in changing Address names or time remaining)

        JScrollPane scroller = new JScrollPane(parkingTable); // makes the table scrollable if the number of locations is greater than what can fit on the page.
        Parking.add(scroller); // adds the scrolling table to the "Parking" Panel.

        Submit.addActionListener(this); // creates the action listener that allows the button to function when clicked.

        this.setVisible(true);// makes the JFrame visible.
    }


    public static void main(String[] args) {
        new JTabbed_Logic();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Submit){
            String str = String.valueOf(meterNum);
            meterNum.setText("");
        }

    }

}
