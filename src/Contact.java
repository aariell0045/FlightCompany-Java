import java.util.Scanner;

public class Contact
{
    Passenger customer;
    FlightCompany fCompany;
    String message;

    public Contact (Passenger p, FlightCompany fc,String ms) // Contact constructor
    {
        customer=p;
        fCompany=fc;
        message=ms;
    }

    public Contact (Passenger p, FlightCompany fc) // Contact constructor
    {
        customer = p;
        fCompany = fc;
    }



    boolean sendToPassenger() //operation contact - adding the message to person
    {
        try
        {
            customer.addMessage(message);
            return true;
        }
        catch (Exception exception){
            return false;
        }

    }

}
