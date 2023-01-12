import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


class FrameEditFlight extends JFrame implements ActionListener {
    // Components of the Form
    private Container c;
    private JLabel title;
    static FlightCompany db;
    private JButton showFlightDetails;  //left
    private JButton editFlight;   //left
    private JButton showPassangersList; //right
    private JButton showWorkersList;    //right
    private JButton saleTicket;     //left
    private JButton removePassanger;    //left
    private JButton addWorker;  //right
    private JButton removeWorker; //right

    private JButton back;

    // constructor, to initialize the components
    // with default values.
    public FrameEditFlight()
    {

        setTitle("Edit flight"); //title of the window
        setBounds(512, 250, 520, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Flight #"+myFlight.getFlightNumber()); //title of the menu
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(192, 30);
        title.setLocation(170, 10);
        c.add(title);

        showFlightDetails = new JButton("Show flight details"); //button to show flight detalis
        showFlightDetails.setFont(new Font("Arial", Font.PLAIN, 15));
        showFlightDetails.setSize(192, 30);
        showFlightDetails.setLocation(50, 75);
        showFlightDetails.addActionListener(this);
        c.add(showFlightDetails);

        editFlight = new JButton("Edit flight details"); //button to edit flight detalis
        editFlight.setFont(new Font("Arial", Font.PLAIN, 15));
        editFlight.setSize(192, 30);
        editFlight.setLocation(50, 125);
        editFlight.addActionListener(this);
        c.add(editFlight);

        saleTicket = new JButton("Sale ticket"); //sale ticket in flight (add passanger)
        saleTicket.setFont(new Font("Arial", Font.PLAIN, 15));
        saleTicket.setSize(192, 30);
        saleTicket.setLocation(50, 175);
        saleTicket.addActionListener(this);
        c.add(saleTicket);

        removePassanger = new JButton("Remove passanger"); //button to remove passanger
        removePassanger.setFont(new Font("Arial", Font.PLAIN, 15));
        removePassanger.setSize(192, 30);
        removePassanger.setLocation(50, 225);
        removePassanger.addActionListener(this);
        c.add(removePassanger);

        showPassangersList = new JButton("Show passangers list"); //button to show all the passnagers in flight
        showPassangersList.setFont(new Font("Arial", Font.PLAIN, 15));
        showPassangersList.setSize(192, 30);
        showPassangersList.setLocation(280, 75);
        showPassangersList.addActionListener(this);
        c.add(showPassangersList);

        showWorkersList = new JButton("Show workers list"); //button to show all the workers in flight
        showWorkersList.setFont(new Font("Arial", Font.PLAIN, 15));
        showWorkersList.setSize(192, 30);
        showWorkersList.setLocation(280, 125);
        showWorkersList.addActionListener(this);
        c.add(showWorkersList);

        addWorker = new JButton("Add worker"); //button to add worker to fligt
        addWorker.setFont(new Font("Arial", Font.PLAIN, 15));
        addWorker.setSize(192, 30);
        addWorker.setLocation(280, 175);
        addWorker.addActionListener(this);
        c.add(addWorker);

        removeWorker = new JButton("Remove worker"); //button to remove worker
        removeWorker.setFont(new Font("Arial", Font.PLAIN, 15));
        removeWorker.setSize(192, 30);
        removeWorker.setLocation(280, 225);
        removeWorker.addActionListener(this);
        c.add(removeWorker);

        back = new JButton("←"); //back button the main menu
        back.setFont(new Font("Arial", Font.PLAIN, 25));
        back.setSize(60, 30);
        back.setLocation(0, 0);
        back.addActionListener(this);
        c.add(back);
        setVisible(true);


        this.addWindowListener(new WindowAdapter() //exit button
        {
            public void windowClosing(WindowEvent we)
            {
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
                            ReadWrite.writingToFile(FrameMainMenu.db);
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


    private void DialogEnterIdAndRemovePassanger() //check input of id of passnager and remove him
    {
        int x = 0,counter=0;
        String s;
        do {

            if (counter==0)
            {
                s = JOptionPane.showInputDialog(this, "Enter passenger id: ", "Remove passenger", JOptionPane.INFORMATION_MESSAGE);
                counter++;
            }
            else
            {
                s=JOptionPane.showInputDialog(this,"Cannot find passenger in the flight with this id number.\n Try again to enter passenger id to remove:","Remove passenger",JOptionPane.INFORMATION_MESSAGE);
            }
            if (s != null) {
                s.replaceAll(" ", "");
                try {
                    x = Integer.parseInt(s);
                } catch (Exception J) {
                    continue;
                }
                if (myFlight.removePassenger(x) == true)
                {
                    FrameMainMenu.db.removesale(myFlight.getFlightNumber(),x);
                    JOptionPane.showMessageDialog(this, "Your passanger removed sucssefuly");
                    return ;
                }
            }else
                break;
        } while (myFlight.removePassenger(x) == false);
        return ;
    }

    private void DialogEnterIdAndRemoveWorker()//check input of id of worker and remove him
    {
        int x = 0, counter=0;
        String s;
        do {
            if (counter==0)
            {
                s = JOptionPane.showInputDialog(this, "Enter worker id: ", "remove worker", JOptionPane.INFORMATION_MESSAGE);
                counter++;
            }
            else
            {
                s=JOptionPane.showInputDialog(this,"Cannot find worker in the flight company with this id number.\n Try again to enter worker id to add:","Add Worker",JOptionPane.INFORMATION_MESSAGE);
            }
            if (s != null) {
                s.replaceAll(" ", "");
                try {
                    x = Integer.parseInt(s);
                } catch (Exception J) {
                    continue;
                }

                if (myFlight.removeWorker(x) == true)
                {
                    JOptionPane.showMessageDialog(this, "your worker removed sucssefuly");
                    return ;
                }

                }
                else
                {
                break;
                }
        } while (myFlight.removeWorker(x) == false);
        return ;
    }


    public void actionPerformed(ActionEvent e) //What happens when each button is pressed
    {
        if (e.getSource() == back)
        {
            this.setVisible(false);
            try {
                FrameMainMenu.main();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource()==editFlight)
        {
            this.setVisible(false);
            FrameEditFlightDetails.main(myFlight.getFlightNumber());
        }

        if (e.getSource() == showFlightDetails)
        {
            JOptionPane.showMessageDialog(this,myFlight.showFlightDetails() , "flight details",
                    JOptionPane.INFORMATION_MESSAGE);

        }

        if (e.getSource() == showPassangersList)
        {
            JTextArea textArea = new JTextArea(myFlight.printPassengersForEditFlight());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "Passangers details",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == showWorkersList)
        {
            JTextArea textArea = new JTextArea(myFlight.printWorkersBoardForEditFlight());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "Workers details",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == removePassanger)
        {
            DialogEnterIdAndRemovePassanger();
        }

        if (e.getSource() == saleTicket)
        {
            if (myFlight.isFull())
            {
                JOptionPane.showMessageDialog(this, "The flight is full, there is no more space on the flight",
                        "Flight is full",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                this.setVisible(false);
                try {
                    PassengerRegister.setFlight(db,myFlight);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }

        if (e.getSource() == addWorker)
        {

            if (myFlight.isFull()) //check if flight is full
            {
                JOptionPane.showMessageDialog(this, "The flight is full, there is no more space on the flight",
                        "Flight is full", JOptionPane.ERROR_MESSAGE);
            }

            else if (myFlight.workersBoard.size() >= 15)
            {
                JOptionPane.showMessageDialog(this, "No more workers can be added to current flight because single flight can have up to 15 workers.",
                        "Flight reached maximum workers", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                Worker workerToAdd=DialogEnterWorkerId();
                if(workerToAdd != null)
                {
                    registerWorker RegisterMyWorker=new registerWorker(workerToAdd,myFlight);
                    try
                    {
                        if (RegisterMyWorker.RegisterToTheFlight())
                        {
                            JOptionPane.showMessageDialog(this,"Adding worker done successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this,"This worker is already exist in the flight.","Already exist",JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }



        if (e.getSource() == removeWorker)
        {
            DialogEnterIdAndRemoveWorker();
        }
    }

    private Worker DialogEnterWorkerId() { //check input of id of worker and return him as object
        int x = 0, counter=0;
        String s;
        do {
            if (counter==0)
            {
                s = JOptionPane.showInputDialog(this, "Enter worker id to add: ", "Add Worker", JOptionPane.INFORMATION_MESSAGE);
                counter++;
            }
            else
            {
                s=JOptionPane.showInputDialog(this,"Cannot find worker in the flight company with this id number.\n Try again to enter worker id to add:","Add Worker",JOptionPane.INFORMATION_MESSAGE);
            }
            if (s != null) {
                s.replaceAll(" ", "");
                try {
                    x = Integer.parseInt(s);
                } catch (Exception J) {
                    continue;
                }
                if (db.findWorker(x) != null) {
                    return db.findWorker(x);
                }
            }else
                break;
        } while (db.findWorker(x) == null);
        return null;
    }



    static Flight myFlight=new Flight();

    public static void main(FlightCompany db_,Flight myFlight_) throws Exception //main does opration the frame
    {
        db=db_;
        myFlight=myFlight_;
        FrameEditFlight f = new FrameEditFlight();

    }
}
