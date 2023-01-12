import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class FrameWorkers extends JFrame implements ActionListener {
    // Components of the Form
    private Container c;
    private JLabel title;
    private JScrollPane WorkersList;
    private JTextArea display;

    private JButton printWorkers;
    private JButton addWorker;
    private JButton removeWorker;
    private JButton findWorker;
    private JButton editWorker;
    private JButton back;


    public FrameWorkers()
    {
        setTitle("Worker station");//window title
        setBounds(512, 250, 520, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);


        title = new JLabel("Worker station");//main title
        title.setFont(new Font("Arial", Font.PLAIN, 35));
        title.setSize(300, 30);
        title.setLocation(130, 10);
        c.add(title);

        editWorker = new JButton("Edit worker");//button that will let change details of exist worker
        editWorker.setFont(new Font("Arial", Font.PLAIN, 15));
        editWorker.setSize(192, 25);
        editWorker.setLocation(50, 170);
        editWorker.addActionListener(this);
        editWorker.setVisible(true);
        c.add(editWorker);

        addWorker = new JButton("Add worker");//button that will let add worker that doesn't exist
        addWorker.setFont(new Font("Arial", Font.PLAIN, 15));
        addWorker.setSize(192, 25);
        addWorker.setLocation(50, 70);
        addWorker.addActionListener(this);
        c.add(addWorker);

        removeWorker = new JButton("Remove Worker");//button that will let remove worker that exist
        removeWorker.setFont(new Font("Arial", Font.PLAIN, 15));
        removeWorker.setSize(192, 25);
        removeWorker.setLocation(50, 120);
        removeWorker.addActionListener(this);
        c.add(removeWorker);

        printWorkers = new JButton("Show all workers");//button that will let you see all the workers
        printWorkers.setFont(new Font("Arial", Font.PLAIN, 15));
        printWorkers.setSize(192, 25);
        printWorkers.setLocation(260, 120);
        printWorkers.addActionListener(this);
        c.add(printWorkers);

        findWorker = new JButton("Find worker");//button that will let you see details on worker
        findWorker.setFont(new Font("Arial", Font.PLAIN, 15));
        findWorker.setSize(192, 25);
        findWorker.setLocation(260, 70);
        findWorker.addActionListener(this);
        c.add(findWorker);


        back = new JButton("←");//Back button
        back.setFont(new Font("Arial", Font.PLAIN, 25));
        back.setSize(60, 30);
        back.setLocation(0, 0);
        back.addActionListener(this);
        c.add(back);


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



    private Worker DialogEnterWorker(String TheReason) {//dialog that will validate number id and return the worker
        int x = 0,counter=0;
        String s;
        do {
            if (counter==0)
            {
                s = JOptionPane.showInputDialog(this, "Enter worker id: ", TheReason+" worker", JOptionPane.INFORMATION_MESSAGE);
                counter++;
            }
            else
            {
                s=JOptionPane.showInputDialog(this,"Cannot find worker in the flight company with this id number.\n Try again to enter worker id:",TheReason+" worker",JOptionPane.INFORMATION_MESSAGE);
            }
            if (s != null)
            {
                s.replaceAll(" ", "");
                try {
                    x = Integer.parseInt(s);
                } catch (Exception J) {
                    continue;
                }
                if (FrameMainMenu.db.findWorker(x) != null) {
                    return FrameMainMenu.db.findWorker(x);
                }
            }else
                break;
        } while (FrameMainMenu.db.findWorker(x) == null);
        return null;
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeWorker)//if remove button clicked
        {
            Worker ReturnedWorker=DialogEnterWorker("Remove");//get the worker from the user
                    if ( ReturnedWorker!= null)//if the worker exist
                    {
                        FrameMainMenu.db.removeWorker(ReturnedWorker.getId());//removing from the flight company
                        JOptionPane.showMessageDialog(this, "Worker removed sucssefuly");
                    }

        }


        if (e.getSource() == editWorker) {//if edit button clicked

            Worker ReturnedWorker=DialogEnterWorker("Edit");//get the worker from the user
            if ( ReturnedWorker!= null) {//if the worker exist
                this.setVisible(false);
                FrameEditWorker.ActivateEditWorker(ReturnedWorker);//go to edit worker frame with the selected worker
            }
        }


        if (e.getSource() == findWorker) {//if edit button clicked
            Worker ReturnedWorker=DialogEnterWorker("Find");//get the worker from the user
            if (ReturnedWorker != null) {//if the worker exist
                        JOptionPane.showMessageDialog(this, "Full name : "+ ReturnedWorker.getFullName() + "\n" + "Id : "+ReturnedWorker.getId() + "\n" +"Phone number : "+ReturnedWorker.getPhoneNumber()+"\n"  + "Adress : "+ReturnedWorker.getAddress() +"\nGender : " +ReturnedWorker.getGender()+ "\n" + "Seniority : "+ ReturnedWorker.getSeniority() , "Worker details",
                                JOptionPane.INFORMATION_MESSAGE);
                    }


        }


        if (e.getSource() == back) {//if back button clicked
            this.setVisible(false);
            try {
                FrameMainMenu.main();//go Back for Main menu
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == addWorker) {//if add worker button clicked
            this.setVisible(false);
            FrameRegisterWorker.main();//go to the registration
        }
        if (e.getSource() == printWorkers) {//if print workers button clicked

            JTextArea textArea = new JTextArea(FrameMainMenu.db.PrintWorkers());//The text that will show up
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            JOptionPane.showMessageDialog(null, scrollPane, "Workers details",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }


        public static void main ()
        {
            FrameWorkers f = new FrameWorkers();
        }//activate the GUI

    }
