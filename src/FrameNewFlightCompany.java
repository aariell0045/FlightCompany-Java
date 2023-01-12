import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

class FrameNewFlightCompany extends JFrame implements ActionListener {
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel companyNumber;
    private JTextField tcompanyNumber;
    private JLabel FoundingYear;
    private JTextField tFoundingYear;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JButton review;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JButton back;
    static JFrame frame;



    public FrameNewFlightCompany()
    {
        setTitle("New Flight Company");
        setBounds(350, 200, 900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("New Flight Company Form");                  // title of the screen
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Company name");                              // one of the fields of flight company
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(150, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();                                           // text area to add name of the flight company
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(250, 100);
        c.add(tname);

        companyNumber = new JLabel("Company number");                   // one of the fields of flight company
        companyNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        companyNumber.setSize(150, 20);
        companyNumber.setLocation(100, 150);
        c.add(companyNumber);

        tcompanyNumber = new JTextField();                                  // text area to add company number of the flight company
        tcompanyNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        tcompanyNumber.setSize(190, 20);
        tcompanyNumber.setLocation(250, 150);
        c.add(tcompanyNumber);

        FoundingYear = new JLabel("Founding year");                     // one of the fields of flight company
        FoundingYear.setFont(new Font("Arial", Font.PLAIN, 15));
        FoundingYear.setSize(150, 20);
        FoundingYear.setLocation(100, 200);
        c.add(FoundingYear);

        tFoundingYear = new JTextField();                                   // text area to add founding year of the flight company
        tFoundingYear.setFont(new Font("Arial", Font.PLAIN, 15));
        tFoundingYear.setSize(190, 20);
        tFoundingYear.setLocation(250, 200);
        c.add(tFoundingYear);

        term = new JCheckBox("Accept terms and conditions.");           // checkbox for accept term and conditions
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 270);
        c.add(term);

        sub = new JButton("Submit");                                    // button to submit
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 300);
        sub.addActionListener(this);
        c.add(sub);

        review = new JButton("Review");                                 // button to review all the text area you filled out
        review.setFont(new Font("Arial", Font.PLAIN, 15));
        review.setSize(100, 20);
        review.setLocation(270, 300);
        review.addActionListener(this);
        c.add(review);

        reset = new JButton("Reset");                                   // button to clear what you filled out
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(390, 300);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();                                             // text area to review all the text area you filled out
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 200);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");                                           // if somthing is missing it will be filled
        res.setFont(new Font("Arial", Font.PLAIN, 15));
        res.setSize(500, 25);
        res.setLocation(100, 245);
        c.add(res);

        resadd = new JTextArea();                                           // text area to the res
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        back = new JButton("←");                                       // button go back the previous page
        back.setFont(new Font("Arial", Font.PLAIN, 25));
        back.setSize(60, 30);
        back.setLocation(0, 0);
        back.addActionListener(this);
        c.add(back);

        setVisible(true);

        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {               // taking care on click X
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
                            ReadWrite.writingToFile(FrameMainMenu.db);              // if the user chose to save
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

    public boolean checkInput()                 // check if all the fields are filled correctly
    {
        if (tname.getText().length()<1)
        {
            res.setForeground(Color.red);
            res.setText("Company name must be at least one letter long.");
            return false;
        }
        if (Integer.parseInt(tcompanyNumber.getText())<0)
        {
            res.setForeground(Color.red);
            res.setText("Company number must be a positive number.");
            return false;
        }
        if (Integer.parseInt(tFoundingYear.getText())<1 || Integer.parseInt(tFoundingYear.getText())>2022)
        {
            res.setForeground(Color.red);
            res.setText("Founding year must make sense...");
            return false;
        }

        return true;

    }

    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == back)          // if click on back go back to previous page
        {
            this.setVisible(false);
            Main.main(null);
        }

            if (e.getSource() == review)    // if click review check all the inputs
        {
            if (checkInput()) {
                res.setForeground(Color.black);
                String data1;
                String data
                        = "Company name: "
                        + tname.getText() + "\n"
                        + "Company number: "
                        + tcompanyNumber.getText() + "\n"
                        + "Founding year: "
                        + tFoundingYear.getText() + "\n";

                tout.setText(data);
                tout.setEditable(false);
                res.setText("To continue, press 'Accept term...' and select 'Submit'");
            }
        }

        if (e.getSource() == sub) {             // if click submit check all the inputs and add them to the flight company

            if (term.isSelected())
            {
                if (checkInput())
                {
                    JOptionPane.showMessageDialog(this,"New flight company created sucssefuly");
                    this.setVisible(false);
                    FlightCompany db = new FlightCompany();
                    db.setName(tname.getText());
                    db.setCompanyNumber(Integer.parseInt(tcompanyNumber.getText()));
                    db.setFoundingYear(Integer.parseInt(tFoundingYear.getText()));
                    try {
                        FrameMainMenu.activateMainGui(false, db);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            else
            {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the" + " terms & conditions...");
            }
        }

        else if (e.getSource() == reset) {              // clear all the inputs and text areas
            String def = "";
            tcompanyNumber.setText(def);
            tname.setText(def);
            tFoundingYear.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            resadd.setText(def);
        }
    }
}
