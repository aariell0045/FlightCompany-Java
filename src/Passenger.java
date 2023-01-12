
import java.util.Scanner;
import java.util.Vector;

public class Passenger extends Person
{
    private boolean handicapped;
    private int numOfBags;
    private Vector<String> messagesBox=new Vector<String>(0);

    public Passenger (String full_Name, int id,String Address,String Gender, String phoneNumber,boolean handi_capped, int numOf_Bags)
    {
        super(full_Name,id,Address,Gender,phoneNumber); // person constructor
        handicapped=handi_capped;
        setNumOfBags(numOf_Bags);
    }

    void addMessage(String ms)
    {
        messagesBox.add(ms);
    }
    public Passenger(){};

    @Override
    public String toString() { // persson toString

        return "\n"+ super.toString() +
                "\n" + handicapped +
                "\n" + numOfBags +
                "\nmessagesBox:\n" + messagesBox.toArray().length + printMessagesBox();
    }

    public String printMessagesBox() // get all the messages in messages box to one String
    {
        String print = "";
        for(String p: messagesBox) {
            print += "\n" + p.toString() ;
        }
        return print;
    }


    void setHandicapped(boolean handicapped)
    {
        this.handicapped=handicapped;
    }

    boolean getHandicapped()
    {
        return handicapped;
    }

    public boolean setNumOfBags(int numOfBags)
    {
        if(numOfBags >= 0)
        {
            this.numOfBags=numOfBags;
            return true;
        }
        return false;
    }

    public int getNumOfBags()
    {
        return numOfBags;
    }
}
