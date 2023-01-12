import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameEditWorker extends JFrame implements ActionListener {
    private static Worker myWorker;//will save the selected worker ,in the final action will be edited
    static Worker newWorker = null;//local worker that will use us to enter all the new details
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel id;
    private JTextField tid;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel add;
    private JTextArea tadd;
    private JLabel seniority;
    private JTextField tseniority;

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
    public FrameEditWorker() {
        setTitle("Edit Worker");//windows title
        setBounds(300, 90, 900, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        Back = new JButton("←");//back button
        Back.setFont(new Font("Arial", Font.PLAIN, 25));
        Back.setSize(60, 30);
        Back.setLocation(0, 0);
        Back.addActionListener(this);
        c.add(Back);

        title = new JLabel("Edit Worker");//main title
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Full name");//one of the fields of worker to enter
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(100, 65);
        c.add(name);

        tname = new JTextField(myWorker.getFullName());//show already the saved details before edit
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 65);
        tname.setEditable(true);
        c.add(tname);

        id = new JLabel("Id");//one of the fields of worker to enter
        id.setFont(new Font("Arial", Font.PLAIN, 15));
        id.setSize(100, 20);
        id.setLocation(100, 95);
        c.add(id);

        tid = new JTextField(String.valueOf(myWorker.getId()));//show already the saved details before edit
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(190, 20);
        tid.setLocation(200, 95);
        tid.setEditable(true);
        c.add(tid);

        mno = new JLabel("Mobile");//one of the fields of worker to enter
        mno.setFont(new Font("Arial", Font.PLAIN, 15));
        mno.setSize(100, 20);
        mno.setLocation(100, 125);
        c.add(mno);

        tmno = new JTextField(myWorker.getPhoneNumber());//show already the saved details before edit
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 20);
        tmno.setLocation(200, 125);
        tmno.setEditable(true);
        c.add(tmno);

        gender = new JLabel("Gender");//one of the fields of worker to enter with two option
        gender.setFont(new Font("Arial", Font.PLAIN, 15));
        gender.setSize(100, 20);
        gender.setLocation(100, 155);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSize(75, 20);
        male.setLocation(200, 155);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSize(80, 20);
        female.setLocation(275, 155);
        c.add(female);
        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
        if(myWorker.getGender()== "male")
            male.setSelected(true);
        else
            female.setSelected(true);


        add = new JLabel("Address");//one of the fields of worker to enter
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSize(100, 20);
        add.setLocation(100, 185);
        c.add(add);

        tadd = new JTextArea(myWorker.getAddress());//show already the saved details before edit
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 185);
        tadd.setLineWrap(true);
        tadd.setEditable(true);
        c.add(tadd);

        seniority = new JLabel("Seniority");//one of the fields of worker to enter
        seniority.setFont(new Font("Arial", Font.PLAIN, 15));
        seniority.setSize(100, 20);
        seniority.setLocation(100, 265);
        c.add(seniority);

        tseniority = new JTextField(String.valueOf(myWorker.getSeniority()));//show already the saved details before edit
        tseniority.setFont(new Font("Arial", Font.PLAIN, 15));
        tseniority.setSize(190, 20);
        tseniority.setLocation(200, 265);
        tseniority.setEditable(true);
        c.add(tseniority);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 350);
        c.add(term);

        review = new JButton("Review");
        review.setFont(new Font("Arial", Font.PLAIN, 15));
        review.setSize(100, 20);
        review.setLocation(200, 385);
        review.addActionListener(this);
        c.add(review);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(90, 385);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(320, 385);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 200);
        tout.setLocation(550, 65);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        validation = new JTextArea();
        validation.setFont(new Font("Arial", Font.PLAIN, 10));
        validation.setSize(300, 30);
        validation.setLocation(100, 450);
        validation.setLineWrap(true);
        validation.setEditable(false);
        validation.setVisible(false);
        c.add(validation);


        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 15));
        res.setForeground(Color.red);
        res.setSize(500, 25);
        res.setLocation(50, 325);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {//taking care on click X
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
                            ReadWrite.writingToFile(FrameMainMenu.db);//if the user decided to save
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




    public boolean validandRegister() {//set all the fields of the worker and if all valid send true and will use the new object,else we will print errors
        newWorker=new Worker();
        String errors = "";
        boolean valid = true;
        res.setForeground(Color.red);

        if (!newWorker.setFullName(tname.getText())) {
            errors = errors + "Your name must be with space and at least one letter for each name " ;
            valid = valid & false;

        }
        try{
            if(!newWorker.setSeniority(Integer.parseInt(tseniority.getText())))
            {
                errors = errors + "Your seniority must be positive number " ;
                valid = valid & false;
            }
        }catch (Exception e)
        {
            errors = errors + "Your seniority must be positive number" ;
            valid = valid & false;
        }

        try {
            if (!newWorker.setId(Integer.parseInt(tid.getText()))) {
                errors = errors + "Id must be positive number" ;
                valid = valid & false;
            }
        }catch (Exception e)
        {
            errors = errors + "Id must be positive number" ;
            valid = valid & false;
        }
        newWorker.setPhoneNumber(tmno.getText());
        newWorker.setAddress(tadd.getText());
        if(male.isSelected()){newWorker.setGender("Male");}else {newWorker.setGender("Female");}
        res.setText(errors);
        res.setForeground(Color.red);
        if(!valid){newWorker=null;}
        return valid;
    }
    public void SetAfterCheck()//after you did all the checks and decided to save ,this will copy all to the db
    {
        Worker EditWorker=FrameMainMenu.db.findWorker(myWorker.getId());
        EditWorker.setFullName(newWorker.getFullName());
        EditWorker.setSeniority(newWorker.getSeniority());
        EditWorker.setAddress(newWorker.getAddress());
        EditWorker.setPhoneNumber(newWorker.getPhoneNumber());
        EditWorker.setId(newWorker.getId());
        EditWorker.setGender(newWorker.getGender());
    }
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== Back)//if back clicked, go back to the main
        {
            this.setVisible(false);
            FrameWorkers.main();

        }
        if (e.getSource() == sub) {//if you want to submit the details and add the worker
            res.setForeground(Color.red);
            if ((term.isSelected()) && validandRegister()) {//only if terms and fields valid go for it
                if(myWorker.getId()==newWorker.getId() ||FrameMainMenu.db.findWorker(newWorker.getId())==null)// check if the worker already exist or you change for new worker
                {
                    res.setText("Changes done Successfully..");
                    res.setForeground(Color.black);
                    JOptionPane.showMessageDialog(this, "Your worker changed sucssefuly");
                    SetAfterCheck();
                    this.setVisible(false);
                    FrameWorkers.main();
                }
                else
                {
                    res.setText("The selected Worker already exist ");
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


        if (e.getSource() == review) {// validate and show the details in text area
            if (term.isSelected() && validandRegister()) {// only if validated fields and term selected

                String data1;
                String data2="";
                String data
                        = "Name : "
                        + tname.getText() + "\n"
                        + "Mobile : "
                        + tmno.getText() + "\n";
                if (male.isSelected())
                    data1 = "Gender : Male"
                            + "\n";
                else
                    data1 = "Gender : Female"
                            + "\n";

                data2= "Id : " +tid.getText() + "\n";
                String data3 = "Address : " + tadd.getText() + "\n";
                String data4= "Seniority: " +tseniority.getText();
                tout.setText(data + data1 + data2 + data3 +data4);
                tout.setEditable(false);
                res.setForeground(Color.black);
                res.setText("Press submit to continue ");
            } else if(!term.isSelected()){
                res.setForeground(Color.red);
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }else
            {
                validandRegister();

            }
        } else if (e.getSource() == reset) {// if reset clicked put in all empty fields
            String def = "";
            tid.setText(def);
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            tseniority.setText(def);
            resadd.setText(def);
        }
    }
    public static void main(String args[])
    {
        FrameEditWorker f = new FrameEditWorker();

    }
    public static void ActivateEditWorker(Worker k){// start the GUI from here after we got worker from the user to edit
        myWorker=k;
        FrameEditWorker.main(null);
    }

}

