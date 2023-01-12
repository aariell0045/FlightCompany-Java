import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.IntStream;
public class FrameEditFlightDetails extends JFrame implements ActionListener{
    static Flight newFlight = null;
    private static Flight ShowDetails;
    private static int myFlightNumber;
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel flightNumber;
    private JTextField tflightNumber;
    private JLabel flightDate;
    private JComboBox tflightDay;
    private JComboBox tflightmonth;
    private JComboBox tflightyear;
    private JSpinner tnumofbags;
    private JLabel numofbags;
    private JLabel destination;
    private JTextField tdestination;
    private JLabel origin;
    private JTextField torigin;
    private JLabel numberofseats;
    private JTextField tnumberofseats;
    private JLabel ticketprice;
    private JTextField tticketprice;

    private JCheckBox term;
    private JButton review;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JTextArea validation;
    private JButton Back;


    // constructor, to initialize the components
    // with default values.
    public FrameEditFlightDetails()  {

        setTitle("Edit flight details ");                                   // title of the screen
        setBounds(300, 90, 900, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        Back = new JButton("←");                                        // button go back the previous page
        Back.setFont(new Font("Arial", Font.PLAIN, 25));
        Back.setSize(60, 30);
        Back.setLocation(0, 0);
        Back.addActionListener(this);
        c.add(Back);

        title = new JLabel("Edit flight details");                      // title of the screen
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        flightNumber = new JLabel("Flight number");                     // one of the fields of flight
        flightNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        flightNumber.setSize(100, 20);
        flightNumber.setLocation(100, 65);
        c.add(flightNumber);

        tflightNumber = new JTextField(String.valueOf(ShowDetails.getFlightNumber()));  // text area to flight number of the flight
        tflightNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        tflightNumber.setSize(190, 20);
        tflightNumber.setLocation(200, 65);
        tflightNumber.setEditable(true);
        c.add(tflightNumber);

        flightDate = new JLabel("Flight Date");                         // one of the fields of flight
        flightDate.setFont(new Font("Arial", Font.PLAIN, 15));
        flightDate.setSize(100, 20);
        flightDate.setLocation(100, 95);
        c.add(flightDate);

        int[] dayarr = IntStream.rangeClosed(1, 31).toArray();

        tflightDay=new JComboBox<Integer>(Arrays.stream(dayarr).boxed().toArray(Integer[]::new));  // text area to the day of the flight
        tflightDay.setFont(new Font("Arial", Font.PLAIN, 15));
        tflightDay.setSize(50,30);
        tflightDay.setLocation(200,95);
        tflightDay.setSelectedItem(ShowDetails.getFlightDate().get(Calendar.DAY_OF_MONTH));
        c.add(tflightDay);

        int[] montharr = IntStream.rangeClosed(1, 12).toArray();

        tflightmonth=new JComboBox<Integer>(Arrays.stream(montharr).boxed().toArray(Integer[]::new));   // text area to the month of the flight
        tflightmonth.setFont(new Font("Arial", Font.PLAIN, 15));
        tflightmonth.setSize(50,30);
        tflightmonth.setLocation(250,95);
        c.add(tflightmonth);

        int[] yeararr = IntStream.rangeClosed((new GregorianCalendar()).get(Calendar.YEAR), (new GregorianCalendar()).get(Calendar.YEAR)+2).toArray();

        tflightyear=new JComboBox<Integer>(Arrays.stream(yeararr).boxed().toArray(Integer[]::new));     // text area to the year of the flight
        tflightyear.setFont(new Font("Arial", Font.PLAIN, 15));
        tflightyear.setSize(70,30);
        tflightyear.setLocation(300,95);
        c.add(tflightyear);


        numofbags = new JLabel(" Max number of bags");                  // one of the fields of flight
        numofbags.setFont(new Font("Arial", Font.PLAIN, 15));
        numofbags.setSize(200, 20);
        numofbags.setLocation(100, 155);
        c.add(numofbags);

        tnumofbags=new JSpinner(new SpinnerNumberModel(0,0,1000,1));    // spinner to the max numebr of bags of the flight
        tnumofbags.setFont(new Font("Arial", Font.PLAIN, 15));
        tnumofbags.setSize(50,25);
        tnumofbags.setLocation(300,160);
        tnumofbags.setValue(ShowDetails.getMaxBags());
        c.add(tnumofbags);

        destination = new JLabel("Destination");                        // one of the fields of flight
        destination.setFont(new Font("Arial", Font.PLAIN, 15));
        destination.setSize(100, 20);
        destination.setLocation(100, 195);
        c.add(destination);

        tdestination = new JTextField(ShowDetails.getDestination());            // text area to the destination of the flight
        tdestination.setFont(new Font("Arial", Font.PLAIN, 15));
        tdestination.setSize(190, 20);
        tdestination.setLocation(200, 195);
        tdestination.setEditable(true);
        c.add(tdestination);

        origin = new JLabel("Origin");                                  // one of the fields of flight
        origin.setFont(new Font("Arial", Font.PLAIN, 15));
        origin.setSize(100, 20);
        origin.setLocation(100, 225);
        c.add(origin);

        torigin = new JTextField(ShowDetails.getOrigin());                  // text area to origin of the flight
        torigin.setFont(new Font("Arial", Font.PLAIN, 15));
        torigin.setSize(190, 20);
        torigin.setLocation(200, 225);
        torigin.setEditable(true);
        c.add(torigin);

        numberofseats = new JLabel("#Seats");                           // one of the fields of flight
        numberofseats.setFont(new Font("Arial", Font.PLAIN, 15));
        numberofseats.setSize(100, 20);
        numberofseats.setLocation(100, 255);
        c.add(numberofseats);

        tnumberofseats = new JTextField(String.valueOf(ShowDetails.getNumberOfSeats()));    // text area to the number of seats of the flight
        tnumberofseats.setFont(new Font("Arial", Font.PLAIN, 15));
        tnumberofseats.setSize(190, 20);
        tnumberofseats.setLocation(200, 255);
        tnumberofseats.setEditable(true);
        c.add(tnumberofseats);

        ticketprice = new JLabel("Ticket price");                       // one of the fields of flight
        ticketprice.setFont(new Font("Arial", Font.PLAIN, 15));
        ticketprice.setSize(100, 20);
        ticketprice.setLocation(100, 285);
        c.add(ticketprice);

        tticketprice = new JTextField(String.valueOf(ShowDetails.getPriceTicket()));    // text area to ticket price of the flight
        tticketprice.setFont(new Font("Arial", Font.PLAIN, 15));
        tticketprice.setSize(190, 20);
        tticketprice.setLocation(200, 285);
        tticketprice.setEditable(true);
        c.add(tticketprice);

        res = new JLabel("");                                           // if somthing is missing it will be filled
        res.setFont(new Font("Arial", Font.PLAIN, 15));
        res.setForeground(Color.red);
        res.setSize(500, 25);
        res.setLocation(50, 310);
        c.add(res);


        term = new JCheckBox("Accept Terms And Conditions.");           // checkbox for accept term and conditions
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 345);
        c.add(term);

        review = new JButton("Review");                                 // button to review all the text area you filled out
        review.setFont(new Font("Arial", Font.PLAIN, 15));
        review.setSize(100, 20);
        review.setLocation(200, 380);
        review.addActionListener(this);
        c.add(review);

        sub = new JButton("Submit");                                // button to submit
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(90, 380);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");                           // button to clear what you filled out
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(320, 380);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();                                     // text area to review all the text area you filled out
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 300);
        tout.setLocation(500, 65);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        validation = new JTextArea();                                       // validation button
        validation.setFont(new Font("Arial", Font.PLAIN, 10));
        validation.setSize(300, 30);
        validation.setLocation(100, 450);
        validation.setLineWrap(true);
        validation.setEditable(false);
        validation.setVisible(false);
        c.add(validation);

        resadd = new JTextArea();                                           // text area to the res
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {       // taking care on click X
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit?", "Exit Confirmation : ",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                {
                    int save = JOptionPane.showConfirmDialog(null,
                            "Do you want to save changes to file?", "Exit Confirmation : ",
                            JOptionPane.YES_NO_OPTION);

                    if (save == JOptionPane.YES_OPTION)
                    {
                        try {
                            ReadWrite.writingToFile(FrameMainMenu.db);      // if the user chose to save
                            JOptionPane.showMessageDialog(null, "The database saved successfully.\nPress ok to exit for sure.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        System.exit(0);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                    if (save == JOptionPane.NO_OPTION)
                    {
                        System.exit(0);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }

                }
                else if (result == JOptionPane.NO_OPTION)
                {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }


    public boolean validandRegister() {             // check if all valid
        newFlight=new Flight();
        String errors = "";
        boolean valid = true;

        try {
            if (!newFlight.setFlightNumber(Integer.parseInt(tflightNumber.getText()))) {
                errors = errors +"flight number must be positive number" + "\n";
                valid = valid & false;
            }
        }catch (Exception e)
        {
            errors =  "flight number must be positive number"+ "\n" ;
            valid = valid & false;
        }


        int day= (int)tflightDay.getSelectedItem();
        int month= (int)tflightmonth.getSelectedItem();
        int year= (int)tflightyear.getSelectedItem();
        if (!newFlight.setFlightDate(new GregorianCalendar(year,month-1,day))) {
            errors =  "flight must be in the future \n" ;
            valid = valid & false;
        }
        if(!newFlight.setMaxBags(Integer.parseInt(tnumofbags.getValue().toString()))) {
            errors =  "number of bags must be positive number and maximum 1000 \n" ;
            valid = valid & false;
        }

        newFlight.setDestination(tdestination.getText());
        newFlight.setOrigin(torigin.getText());

        try {
            if (!newFlight.setNumberOfSeats(Integer.parseInt(tnumberofseats.getText()))) {
                errors =  "number of seats must be positive number and maximum 550 \n" ;
                valid = valid & false;
            }
        }catch (Exception e)
        {
            errors =  "number of seats must be positive number and maximum 550 \n" ;
            valid = valid & false;
        }
        try {
            if (!newFlight.setPriceTicket(Integer.parseInt(tticketprice.getText()))) {
                errors = "ticket price can be 0-free or positive number \n" ;
                valid = valid & false;
            }
        }catch (Exception e)
        {
            errors = "ticket price can be 0-free or positive number \n" ;
            valid = valid & false;
        }


        res.setText(errors);
        res.setForeground(Color.red);
        if(!valid){newFlight=null;}
        return valid;
    }
    public void SetAfterCheck()             // set all the changes the the flight
    {
        Flight EditFlight=FrameMainMenu.db.findFlight(myFlightNumber);
        EditFlight.setFlightDate(newFlight.flightDate);
        EditFlight.setDestination(newFlight.getDestination());
        EditFlight.setOrigin(newFlight.getOrigin());
        EditFlight.setMaxBags(newFlight.getMaxBags());
        EditFlight.setNumberOfSeats(newFlight.getNumberOfSeats());
        EditFlight.setPriceTicket(newFlight.getPriceTicket());
        EditFlight.setFlightNumber(newFlight.getFlightNumber());


    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {                // if click on back go back to previous page
            this.setVisible(false);
            try {
                FrameEditFlight.main(FrameMainMenu.db,ShowDetails);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == sub) {                 // if click submit check all the inputs and add them to the flight company
            if ((term.isSelected()) && validandRegister()) {
                if(newFlight.getFlightNumber()==myFlightNumber ||FrameMainMenu.db.findFlight(newFlight.getFlightNumber())==null)
                {
                    res.setText("changes have been done Successfully..");
                    JOptionPane.showMessageDialog(this,"your flight changed sucssefuly");
                    this.setVisible(false);
                    SetAfterCheck();
                    try {
                        FrameEditFlight.main(FrameMainMenu.db,newFlight);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }else
                {
                    res.setText("flight number already exist, please choose another one");
                }


            }else if(!term.isSelected())
            {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
            else
            {
                validandRegister();
            }
        }


        if (e.getSource() == review) {              // if click review check all the inputs
            if (term.isSelected() && validandRegister()) {

                String data1;
                String data2;
                String data
                        = "Flight number : "
                        + tflightNumber.getText() + "\n"
                        + "Flight date : "
                        + tflightDay.getSelectedItem()+"/" + tflightmonth.getSelectedItem()+"/"+ tflightyear.getSelectedItem()+"\n";


                data1 = "Max number of bags : " + tnumofbags.getValue()+ "\n";
                data2= "Destination : " + tdestination.getText()+ "\n";
                String data3= "Origin : " + torigin.getText()+ "\n";
                String data4= "Number of seats : " + tnumberofseats.getText()+ "\n";
                String data5= "ticket price : " + ticketprice.getText();

                tout.setText(data  + data1 + data2 + data3+data4+data5);
                tout.setEditable(false);
                res.setText("please enter the submit to save the details");
            } else if(!term.isSelected()){
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }else
            {
                validandRegister();

            }
        } else if (e.getSource() == reset) {        // clear all the inputs and text areas
            String def = "";
            tflightNumber.setText(def);
            tflightDay.setSelectedItem(1);
            tflightmonth.setSelectedItem(1);
            tnumofbags.setValue(0);
            tdestination.setText(def);
            torigin.setText(def);
            tnumberofseats.setText(def);
            tticketprice.setText(def);
            resadd.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            resadd.setText(def);
        }
    }
    public static void main(int flightNumber)       // start of the frame
    {
        myFlightNumber=flightNumber;
        ShowDetails=FrameMainMenu.db.findFlight(flightNumber);
        FrameEditFlightDetails myFlight= new FrameEditFlightDetails();
    }

}
