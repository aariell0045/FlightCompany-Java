public class PassengerRegister {
    static  Flight myFlight;
    static FlightCompany db;

    public static void setFlight(FlightCompany db_,Flight fl) throws Exception //should activate from here
    {
        db=db_;
        myFlight=fl;
       main(null);
    }

    public static void main(String[] args) throws Exception// call to the gui
    {
        FrameRegisterPassanger f = new FrameRegisterPassanger(db,myFlight);
    }
    public static void AddThePassanger(Passenger p)// after passanger ready add him to flight
    {
        saleTicket sale=new saleTicket(myFlight,p);// create a sale ,and add the passanger to the flight
        sale.buyTheTicket();
        FrameMainMenu.db.AddSaleTicket(sale);
    }

}
