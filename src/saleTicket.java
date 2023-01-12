import java.util.Calendar;
import java.util.GregorianCalendar;

public class saleTicket
{
    Flight currentFlight;
    Passenger customer;
    GregorianCalendar saleDate;

    public saleTicket(Flight currentFlight_, Passenger customer_)//for sale now
    {
        currentFlight=currentFlight_;
        customer=customer_;
        saleDate=new GregorianCalendar();

    }
    public saleTicket(Flight currentFlight_, Passenger customer_,GregorianCalendar saleDate)//for sale with a selected date
    {
        currentFlight=currentFlight_;
        customer=customer_;
        this.saleDate=saleDate;

    }

    int getFlightNumber()
    {
        return  currentFlight.getFlightNumber();
    }

    double getPrice()
    {
        return currentFlight.getPriceTicket();
    }

    void setPrice(int newPrice)
    {
        currentFlight.setPriceTicket(newPrice);
    }

    void buyTheTicket()
    {
        currentFlight.registerPassenger(customer);
    }//activate the registration
    public String PrintSaleTicket()//print for user, adding +1 on month cause gregorian date save it less 1
    {
        return
                "Flight Number : " + getFlightNumber() +
                        "\ncustomer id : " + customer.getId() +
                        "\nsale Date : " + saleDate.get(Calendar.DAY_OF_MONTH)+ "/" +(saleDate.get(Calendar.MONTH)+1) +"/" + saleDate.get(Calendar.YEAR) +"\n" ;

    }
    public String FixedDate()//taking care on dates like d/m/yyyy
    {
        String dateFixed="";
        if((saleDate.get(Calendar.DAY_OF_MONTH))<10)
        {
            dateFixed="0"+saleDate.get(Calendar.DAY_OF_MONTH)+"/";
        }
        else
            dateFixed+=saleDate.get(Calendar.DAY_OF_MONTH)+"/";
        if((saleDate.get(Calendar.MONTH)+1)<10)
        {
            dateFixed+="0"+(saleDate.get(Calendar.MONTH)+1)+"/";
        }
        else
            dateFixed+=(saleDate.get(Calendar.MONTH)+1)+"/";

        dateFixed+=saleDate.get(Calendar.YEAR);
        return  dateFixed;
    }
    @Override
    public String toString() {//will be useful for printing to file
        return
                "" + getFlightNumber() +"\n"+ customer.getId() +"\n"+ FixedDate() + "\n";

    }




}
