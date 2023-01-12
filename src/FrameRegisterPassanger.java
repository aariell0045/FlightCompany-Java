import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class FrameRegisterPassanger extends JFrame implements ActionListener
 {
     static Passenger newPassanger = null;//local passanger that will use us to enter all the new details
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
     private JLabel handicapped;
     private JRadioButton yes;
     private JRadioButton no;
     private ButtonGroup handigroup;
     private JSpinner tnumofbags;
     private JLabel numofbags;
     private JCheckBox term;
     private JButton review;
     private JButton sub;
     private JButton reset;
     private JTextArea tout;
     private JLabel res;
     private JTextArea resadd;
     private JTextArea validation;
     private JButton Back;

     static  Flight myFlight;
     static FlightCompany db;

     // constructor, to initialize the components
     // with default values.
     public FrameRegisterPassanger(FlightCompany db_,Flight myFlight_ )
     {
         myFlight=myFlight_;
         db=db_;

         setTitle("Sale ticket");//windows title
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

         title = new JLabel("Sale ticket");//main title
         title.setFont(new Font("Arial", Font.PLAIN, 30));
         title.setSize(300, 30);
         title.setLocation(300, 30);
         c.add(title);

         name = new JLabel("Full name");//one of the fields of passanger to enter
         name.setFont(new Font("Arial", Font.PLAIN, 15));
         name.setSize(100, 20);
         name.setLocation(100, 65);
         c.add(name);

         tname = new JTextField();
         tname.setFont(new Font("Arial", Font.PLAIN, 15));
         tname.setSize(190, 20);
         tname.setLocation(200, 65);
         c.add(tname);

         id = new JLabel("Id");//one of the fields of passanger to enter
         id.setFont(new Font("Arial", Font.PLAIN, 15));
         id.setSize(100, 20);
         id.setLocation(100, 95);
         c.add(id);

         tid = new JTextField();
         tid.setFont(new Font("Arial", Font.PLAIN, 15));
         tid.setSize(190, 20);
         tid.setLocation(200, 95);
         c.add(tid);

         mno = new JLabel("Mobile");//one of the fields of passanger to enter
         mno.setFont(new Font("Arial", Font.PLAIN, 15));
         mno.setSize(100, 20);
         mno.setLocation(100, 125);
         c.add(mno);

         tmno = new JTextField();
         tmno.setFont(new Font("Arial", Font.PLAIN, 15));
         tmno.setSize(190, 20);
         tmno.setLocation(200, 125);
         c.add(tmno);

         gender = new JLabel("Gender");//one of the fields of passanger to enter with two option
         gender.setFont(new Font("Arial", Font.PLAIN, 15));
         gender.setSize(100, 20);
         gender.setLocation(100, 155);
         c.add(gender);

         male = new JRadioButton("Male");
         male.setFont(new Font("Arial", Font.PLAIN, 15));
         male.setSelected(true);
         male.setSize(75, 20);
         male.setLocation(200, 155);
         c.add(male);

         female = new JRadioButton("Female");
         female.setFont(new Font("Arial", Font.PLAIN, 15));
         female.setSelected(false);
         female.setSize(80, 20);
         female.setLocation(275, 155);
         c.add(female);

         gengp = new ButtonGroup();
         gengp.add(male);
         gengp.add(female);


         add = new JLabel("Address");//one of the fields of passanger to enter
         add.setFont(new Font("Arial", Font.PLAIN, 15));
         add.setSize(100, 20);
         add.setLocation(100, 185);
         c.add(add);

         tadd = new JTextArea();
         tadd.setFont(new Font("Arial", Font.PLAIN, 15));
         tadd.setSize(200, 75);
         tadd.setLocation(200, 185);
         tadd.setLineWrap(true);
         c.add(tadd);

         handicapped = new JLabel("Handicapped");//one of the fields of passanger to enter with two option
         handicapped.setFont(new Font("Arial", Font.PLAIN, 15));
         handicapped.setSize(150, 20);
         handicapped.setLocation(100, 265);
         c.add(handicapped);

         yes = new JRadioButton("yes");
         yes.setFont(new Font("Arial", Font.PLAIN, 15));
         yes.setSelected(true);
         yes.setSize(75, 20);
         yes.setLocation(250, 265);
         c.add(yes);

         no = new JRadioButton("no");
         no.setFont(new Font("Arial", Font.PLAIN, 15));
         no.setSelected(false);
         no.setSize(80, 20);
         no.setLocation(350, 265);
         c.add(no);
         handigroup = new ButtonGroup();
         handigroup.add(yes);
         handigroup.add(no);

         numofbags = new JLabel("Number of bags");//one of the fields of passanger to enter with spinner
         numofbags.setFont(new Font("Arial", Font.PLAIN, 15));
         numofbags.setSize(200, 20);
         numofbags.setLocation(100, 305);
         c.add(numofbags);

         tnumofbags=new JSpinner(new SpinnerNumberModel(0,0,4,1));
         tnumofbags.setFont(new Font("Arial", Font.PLAIN, 15));
         tnumofbags.setSize(30,25);
         tnumofbags.setLocation(240,300);
         c.add(tnumofbags);

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
         tout.setSize(300, 300);
         tout.setLocation(500, 65);
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

     public boolean validandRegister() {//set all the fields of the new passanger and if all valid send true and will use the new object,else we will print errors
         newPassanger=new Passenger();
         String errors = "";
         boolean valid = true;

         if (!newPassanger.setFullName(tname.getText())) {
             errors = errors + "your name must be with space and at least one letter for each name " ;
             valid = valid & false;

         }
         if (!newPassanger.setNumOfBags(Integer.parseInt(tnumofbags.getValue().toString()))) {
             errors = errors + "Number of bags must be positive" ;
             valid = valid & false;
         }

         if (Integer.parseInt(tnumofbags.getValue().toString()) + myFlight.getCurrentNumberOfBags()  >myFlight.getMaxBags())
         {
             errors = errors + "There is no place for this amount of bags, try less." ;
             valid = valid & false;
         }
             if (yes.isSelected()) {
             newPassanger.setHandicapped(true);
         } else {
             newPassanger.setHandicapped(false);
         }
         try {
             if (!newPassanger.setId(Integer.parseInt(tid.getText()))) {
                 errors = errors + "id must be positive number" ;
                 valid = valid & false;
             }
         }catch (Exception e)
         {
             errors = errors + "id must be positive number" ;
             valid = valid & false;
         }
         newPassanger.setPhoneNumber(tmno.getText());
         newPassanger.setAddress(tadd.getText());
         if(male.isSelected()){newPassanger.setGender("male");}else {newPassanger.setGender("female");}
         res.setText(errors);
         res.setForeground(Color.red);
         if(!valid){newPassanger=null;}
         return valid;
     }

     // method actionPerformed()
     // to get the action performed
     // by the user and act accordingly
     public void actionPerformed(ActionEvent e) {

         if (e.getSource() == Back)//if back clicked, go back to the main
         {
             this.setVisible(false);
             try {
                 FrameEditFlight.main(db,myFlight);
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
         }


         if (e.getSource() == sub) {//if you want to submit the details and add the worker
             if ((term.isSelected()) && validandRegister()) {
                JOptionPane.showMessageDialog(this,"Sale done successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                PassengerRegister.AddThePassanger(newPassanger);
                 try {
                     FrameEditFlight.main(db,myFlight);
                 } catch (Exception ex) {
                     ex.printStackTrace();
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
                 if (term.isSelected() && validandRegister()) {

                     String data1;
                     String data2;
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
                     if (yes.isSelected())
                         data2 = "handicapped : Yes"
                                 + "\n";
                     else
                         data2 = "handicapped : Yes"
                                 + "\n";

                     String data3 = "Address : " + tadd.getText();
                     String data4= "Id : " + tid.getText();
                     tout.setText(data +data4 + data1 + data2 + data3);
                     tout.setEditable(false);
                     res.setForeground(Color.black);
                     res.setText("Press submit to countinue");
                 } else if(!term.isSelected()){
                     tout.setText("");
                     resadd.setText("");
                     res.setText("Please accept the"
                             + " terms & conditions");
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

                 resadd.setText(def);
             }
         }
     }
