import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;

class FrameMainMenu extends JFrame implements ActionListener {
    static FlightCompany db;


    //components of the form
    private Container c;
    private JLabel title;
    private JButton sub;
    private JButton reset;
    private JButton review;

    private JButton editFlight;
    private JButton addFlight;
    private JButton removeFlight;
    private JButton showAllFlight;
    private JButton editCompanyDetails;
    private JButton showCompanyIncome;
    private JButton dailyFlightsCheck;
    private JButton workersInCompany;
    private JButton showCompanyDetails;
    private JButton save;
    private JButton showAllSaleTickets;
    private JButton contactPassenger;

    private JButton back;


    public FrameMainMenu()
    {

        /*setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);*/


        setTitle("Main Menu");                                          // title of the screen
        setBounds(512, 250, 520, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Main Menu");                            // title of the screen
        title.setFont(new Font("Arial", Font.PLAIN, 35));
        title.setSize(300, 30);
        title.setLocation(170, 10);
        c.add(title);

        editFlight = new JButton("Edit flight");                    // button to edit flight
        editFlight.setFont(new Font("Arial", Font.PLAIN, 15));
        editFlight.setSize(192, 25);
        editFlight.setLocation(50, 70);
        editFlight.addActionListener(this);
        c.add(editFlight);

        addFlight = new JButton("Add flight");                      // button to add new flight
        addFlight.setFont(new Font("Arial", Font.PLAIN, 15));
        addFlight.setSize(192, 25);
        addFlight.setLocation(50, 120);
        addFlight.addActionListener(this);
        c.add(addFlight);

        removeFlight = new JButton("Remove flight");                // button to remove flight
        removeFlight.setFont(new Font("Arial", Font.PLAIN, 15));
        removeFlight.setSize(192, 25);
        removeFlight.setLocation(50, 170);
        removeFlight.addActionListener(this);
        c.add(removeFlight);

        showAllFlight = new JButton("Show all flights");            // button to show all flights
        showAllFlight.setFont(new Font("Arial", Font.PLAIN, 15));
        showAllFlight.setSize(192, 25);
        showAllFlight.setLocation(50, 220);
        showAllFlight.addActionListener(this);
        c.add(showAllFlight);

        dailyFlightsCheck = new JButton("Daily flights check");     // button to start the daily flight check
        dailyFlightsCheck.setFont(new Font("Arial", Font.PLAIN, 15));
        dailyFlightsCheck.setSize(192, 25);
        dailyFlightsCheck.setLocation(50, 270);
        dailyFlightsCheck.addActionListener(this);
        c.add(dailyFlightsCheck);

        showCompanyDetails = new JButton("Show company details");   // button to show the company details
        showCompanyDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        showCompanyDetails.setSize(192, 25);
        showCompanyDetails.setLocation(260, 70);
        showCompanyDetails.addActionListener(this);
        c.add(showCompanyDetails);

        editCompanyDetails = new JButton("Edit company details");   // button to edit company details
        editCompanyDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        editCompanyDetails.setSize(192, 25);
        editCompanyDetails.setLocation(260, 120);
        editCompanyDetails.addActionListener(this);
        c.add(editCompanyDetails);

        showCompanyIncome = new JButton("Show company income");     // button to show company income
        showCompanyIncome.setFont(new Font("Arial", Font.PLAIN, 15));
        showCompanyIncome.setSize(192, 25);
        showCompanyIncome.setLocation(260, 170);
        showCompanyIncome.addActionListener(this);
        c.add(showCompanyIncome);

        workersInCompany = new JButton("Workers in company");       // button to see all the workers in the company
        workersInCompany.setFont(new Font("Arial", Font.PLAIN, 15));
        workersInCompany.setSize(192, 25);
        workersInCompany.setLocation(260, 220);
        workersInCompany.addActionListener(this);
        c.add(workersInCompany);

        contactPassenger = new JButton("Contact passenger");        // button to contact with the passenger and leave him a meesage
        contactPassenger.setFont(new Font("Arial", Font.PLAIN, 15));
        contactPassenger.setSize(192, 25);
        contactPassenger.setLocation(260, 270);
        contactPassenger.addActionListener(this);
        c.add(contactPassenger);

        save = new JButton("Save");                                 // button to save all changes that has been done
        save.setFont(new Font("Arial", Font.PLAIN, 15));
        save.setSize(192, 25);
        save.setLocation(260, 320);
        save.addActionListener(this);
        c.add(save);

        showAllSaleTickets = new JButton("Show all sale tickets");  // button to show all the sales of the flight company
        showAllSaleTickets.setFont(new Font("Arial", Font.PLAIN, 15));
        showAllSaleTickets.setSize(192, 25);
        showAllSaleTickets.setLocation(50, 320);
        showAllSaleTickets.addActionListener(this);
        c.add(showAllSaleTickets);


        back = new JButton("←");                                    // button go back the previous page
        back.setFont(new Font("Arial", Font.PLAIN, 25));
        back.setSize(60, 30);
        back.setLocation(0, 0);
        back.addActionListener(this);
        c.add(back);

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


    private Flight DialogEnterFlight(String cause,String title) { //dialog that will validate flight number and return the flight
        int x = 0,counter=0;
        String s;
        do {
            if (counter == 0)
            {
                s = JOptionPane.showInputDialog(this, "Enter flight number "+cause+":", title, JOptionPane.INFORMATION_MESSAGE);
                counter++;
            }
            else
            {
                s=JOptionPane.showInputDialog(this,"Cannot find flight with this flight number.\n Try again to enter flight number "+cause+":",title,JOptionPane.INFORMATION_MESSAGE);
            }
            if (s != null) {
                s.replaceAll(" ", "");
                try {
                    x = Integer.parseInt(s);
                } catch (Exception J) {
                    continue;
                }
                if (FrameMainMenu.db.findFlight(x) != null) {
                    return FrameMainMenu.db.findFlight(x);
                }
            }else
                break;
        } while (FrameMainMenu.db.findFlight(x) == null);
        return null;
    }

    private void DialogEnterFlightAndRemove() { //dialog that will validate flight number and remove the flight
        int x = 0,counter=0;
        String s;
        do {
            if (counter == 0)
            {
                s = JOptionPane.showInputDialog(this, "Enter flight number to delete:", "Delete flight", JOptionPane.INFORMATION_MESSAGE);
                counter++;
            }
            else
            {
                s=JOptionPane.showInputDialog(this,"Cannot find flight with this flight number.\n Try again to enter flight number to delete:","Delete flight",JOptionPane.INFORMATION_MESSAGE);
            }

             if (s != null) {
                s.replaceAll(" ", "");
                try {
                    x = Integer.parseInt(s);
                } catch (Exception J) {
                    continue;
                }
                if (FrameMainMenu.db.findFlight(x) != null) {
                    Flight f = FrameMainMenu.db.findFlight(x);
                    FrameMainMenu.db.removeFlight(f);
                    JOptionPane.showMessageDialog(this,"Flight number "+x+" has been removed successfully","Remove flight",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"wrong flight number","wrong flight number",
                            JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }
            }else
                break;
        } while (FrameMainMenu.db.findFlight(x) == null);
        return ;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== showAllSaleTickets)          // if click on show all sale tickets show all the sales
        {
            JTextArea textArea = new JTextArea("Your sales : \n"+db.saleTicketsprint());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "Your sales",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == contactPassenger)      // if click on contact passanger leave a message to the passanger and check if he is exists
        {
            Flight flightReturned = DialogEnterFlight("where the passenger is","Contact passenger");

            if (flightReturned!=null)
            {
                Contact c;
                int x = 0,counter=0,check=1;
                String s,message;
                do {
                    if (counter==0)
                    {
                        s = JOptionPane.showInputDialog(this, "Enter passenger id to send a message:", "Contact passenger", JOptionPane.INFORMATION_MESSAGE);
                        counter++;
                    }
                    else
                    {
                        s=JOptionPane.showInputDialog(this,"There is no passanger with this id in the flight.\n Try again to enter passenger id to send a message:","Contact passenger",JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (s != null)
                    {
                        s.replaceAll(" ", "");
                        try {
                            x = Integer.parseInt(s);
                        } catch (Exception J) {
                            continue;
                        }

                        Passenger temp=null;
                        for (Passenger p: flightReturned.passengersBoard)
                        {
                            if (p.getId() == x)
                            {
                                temp=p;
                                break;
                            }
                        }

                        if (temp!=null)
                        {
                            message = JOptionPane.showInputDialog(this, "Enter a message:", "Enter a message", JOptionPane.INFORMATION_MESSAGE);
                            c=new Contact(temp,db,message);
                            if (c.sendToPassenger())
                            {
                                check=0;
                                JOptionPane.showMessageDialog(this,"The message sent successfully","Contact assenger", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }else
                        break;
                } while  (check!=0);
            }





        }


        if (e.getSource() == back)                  // if click on back go back to previous page
        {
            try {
                ReadWrite.writingToFile(db);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            this.setVisible(false);
            Main.main(null);
        }

        if (e.getSource() == editCompanyDetails)    // if click on edit company details go to frame edit flight company
        {
            this.setVisible(false);
            try {
                FrameEditFlightCompany.ActiveEditFlightCompany(FrameMainMenu.db);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == save)                  // if click on save, save to the flight company (to data base)
        {
            try {
                ReadWrite.writingToFile(db);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(this,"The database saved the information successfully!", "Save",
                    JOptionPane.INFORMATION_MESSAGE);
        }


        if (e.getSource() == showCompanyDetails)    // show the company details
        {
            JOptionPane.showMessageDialog(this,"Name: "+db.getName()+
                    "\nNumber: "+db.getCompanyNumber()+"\nFounding year: "+db.getFoundingYear(), "Company details",
                    JOptionPane.INFORMATION_MESSAGE);

        }


        if (e.getSource() == editFlight)            // if click on edit flight go the frame edit flight
        {
            Flight flightReturned = DialogEnterFlight("to edit","Edit flight");
            if(flightReturned != null)
            {
                this.setVisible(false);
                try {
                    FrameEditFlight.main(db,flightReturned);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }

       if (e.getSource() == addFlight)              // if click on add flight go the frame add flight
       {
           this.setVisible(false);
           try {
               FrameAddFlight.main();
           } catch (Exception ex) {
               ex.printStackTrace();
           }
       }

        if (e.getSource() == removeFlight)          // if click on add flight open dialog remove flight
        {
            DialogEnterFlightAndRemove();
        }

        if (e.getSource() == workersInCompany)      // if click on workers in company go the frame workers
        {
            this.setVisible(false);
            FrameWorkers.main();

        }

        if (e.getSource() == showCompanyIncome)     // if click on show company income, show the company income from all the flights
        {
            JOptionPane.showMessageDialog(this,"company income: "+db.calcTotalIncome()+" Dollars" , "Company income",
                    JOptionPane.INFORMATION_MESSAGE);

        }

        if (e.getSource() == showAllFlight)         // show all the flight in text area
        {

            JTextArea textArea = new JTextArea(db.showAllFlightDetails());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "Flights details",
                    JOptionPane.INFORMATION_MESSAGE);

        }

        if (e.getSource() == dailyFlightsCheck)         // start multi thraded function daily flight check
        {
            String flightRemoved = db.checkFlights();
            if (flightRemoved == "")
            {
                JOptionPane.showMessageDialog(this, "No flights removed.", "Daily flights check",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JTextArea textArea = new JTextArea("The flights that has been removed are: \n"+flightRemoved);
                JScrollPane scrollPane = new JScrollPane(textArea);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                scrollPane.setPreferredSize( new Dimension( 300, 300 ) );
                JOptionPane.showMessageDialog(null, scrollPane, "Daily flights check",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }

    public static void main() throws Exception
    {
        FrameMainMenu f = new FrameMainMenu();

    }


    public static void activateMainGui(Boolean choise, FlightCompany DB) throws Exception {     // start of the frame
        if (choise)
        {
            db=ReadWrite.readingFromFile();
        }
        else
        {
            db=DB;
        }
        main();
    }

}
