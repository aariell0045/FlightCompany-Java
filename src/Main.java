/*
Students:
Dor Agababa 208133116
Matan Shemesh 318449501
Ariel Cohen 322624750
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

public class Main {// The project start from here
    //frame components
    private JButton Load;
    private JPanel myPanel;
    private JButton New;

    public Main()
    {
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we) {//taking care on click X
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit?", "Exit Confirmation : ",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }

                else if (result == JOptionPane.NO_OPTION)
                {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                }
            }
        });

        Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                try {
                        FrameMainMenu.activateMainGui(true,null);//load files clicked ,so go directly to the main and load files
                    }
                catch (Exception ex)
                {
                        ex.printStackTrace();
                    }
            }

        });

        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                try {
                    NewFlightCompany.main();//create new flight company and override the database
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    static JFrame frame;
    public static void main(String[] args)//sets the frame
    {

        frame=new JFrame("start");
        frame.setContentPane(new Main().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500  , 300);
        frame.setLocation(512,250);
    }

}
