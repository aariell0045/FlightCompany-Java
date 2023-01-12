import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Flight
{
    private int flightNumber;
    GregorianCalendar flightDate;
    Vector <Passenger> passengersBoard=new Vector<Passenger>(0);
    Vector <Worker> workersBoard=new Vector<Worker>(0);
    private String destination;
    private String origin;
    private int numberOfSeats;
    private int maxBags;
    private int priceTicket;

    // Flight constructor
    public Flight(int flightNumber, GregorianCalendar flightDate, String destination, String origin, int numberOfSeats, int maxBags, int priceTicket) {
        setFlightNumber(flightNumber);
        this.flightDate = flightDate;
        this.destination = destination;
        this.origin = origin;
        setNumberOfSeats(numberOfSeats);
        setMaxBags(maxBags);
        this.priceTicket = priceTicket;
    }

    public Flight(){};    // Flight constructor


    public int getCurrentNumberOfBags() //return the current amount of bags on the flight
    {
        int counter=0;
        for (Passenger p : passengersBoard)
        {
            counter+=p.getNumOfBags();
        }
        return counter;
    }
    public  Passenger FindPassangerOnBoard(int id) //find passanger in the flight by id
    {
        for(Passenger i : passengersBoard)
        {
            if(i.getId()==id)
            {
                return  i;
            }
        }
        return null;
    }


    public void setDestination(String destination) //set Destination
    {
        this.destination = destination;
    }

    public boolean setFlightDate(GregorianCalendar flightDate) //set Flight Date
    {
        if(flightDate.after(new GregorianCalendar()))
        {
            this.flightDate=flightDate;
            return true;
        }
        return false;
    }

    public boolean setFlightNumber(int flightNumber) // change the flight number
    {
        if(flightNumber>0)
        {
            this.flightNumber=flightNumber;
            return true;
        }
        return false;
    }

    public boolean setMaxBags(int maxBags) //change the maximum number of bags on flight
    {
        if(maxBags>=0&& maxBags<=1000)
        {
            this.maxBags = maxBags;
            return true;
        }
        return false;
    }

    public boolean setNumberOfSeats(int numberOfSeats) //change the number of seats on flight
    {
        if(numberOfSeats>=0 && numberOfSeats<=550) {
            this.numberOfSeats = numberOfSeats;
            return true;
        }
        else
            return false;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    } // set origin for the flight

    public int getMaxBags() {
        return maxBags;
    } //return the max amount of bags on flight

    public int getNumberOfSeats() //return the number of seats on flight
    {
        return numberOfSeats;
    }

    public String getDestination() {
        return destination;
    } //return the flight's destination

    public String getOrigin() {
        return origin;
    } //return the flight's origin

    public String printDate() //printing the the flight date
    {
        return flightDate.get(Calendar.DAY_OF_MONTH) + "/" + (flightDate.get(Calendar.MONTH) + 1) + "/" + flightDate.get(Calendar.YEAR);
    }

    public String toString() { // flight toString
        return "\n" +
                flightNumber
                + "\n" +FixedDate()
                + "\n" + origin
                + "\n" + destination
                + "\n" + numberOfSeats
                + "\n" + maxBags
                + "\n" + priceTicket
                + "\npassengers:\n" + passengersBoard.toArray().length +printPassengers()
                + "\nworkers on board:\n"+ workersBoard.toArray().length + printWorkersBoard();

    }

    public String FixedDate() //fixed format for toString of flight
    {
        String dateFixed="";
        if((flightDate.get(Calendar.DAY_OF_MONTH))<10)
        {
            dateFixed="0"+flightDate.get(Calendar.DAY_OF_MONTH)+"/";
        }
        else
            dateFixed+=flightDate.get(Calendar.DAY_OF_MONTH)+"/";
        if((flightDate.get(Calendar.MONTH)+1)<10)
        {
            dateFixed+="0"+(flightDate.get(Calendar.MONTH)+1)+"/";
        }
        else
            dateFixed+=(flightDate.get(Calendar.MONTH)+1)+"/";

        dateFixed+=flightDate.get(Calendar.YEAR);
        return  dateFixed;
    }

    public String printPassengersForEditFlight() { //fixed format to print vector passengers.
        String res = "";
        for (Passenger p : passengersBoard) {
            res = res + "Name : " + p.getFullName() + "\n" + "Id : " + p.getId() + "\n" +
                    "Handicapped : " + p.getHandicapped() + "\n" + "Number of bags : " +p.getNumOfBags() +
                    "\nMessages box: " +p.printMessagesBox() +"\n" + "\n";
        }
        return res;
    }

    public String printPassengers(){ //another format to print vector passengers - for GUI
        String print = "";
        for(Passenger p: passengersBoard) {
            print += p.toString();
        }
        return print;
    }

    public String showFlightDetails() // show Flight Details by string
    {
        return "Flight number: " + this.getFlightNumber()+
                "\nflightDate: " + this.printDate() + "\nDestination: " + this.getDestination() + "\nOrigin: " + this.getOrigin() +
                "\nNumber of seats: "+ this.getNumberOfSeats()+ "\nCurrent number of passengers: "+this.passengersBoard.size() +
                "\nCurrent number of workers: "+this.workersBoard.size()+
                "\nNumber of seats available: " +
                this.numberOfSeatsAvailable()  +"\nMaximum number of bags possible on the flight: " + this.getMaxBags() +
                "\nCurrent number of bags: " + this.getCurrentNumberOfBags() +
                "\nTicket price: " + this.getPriceTicket() + " Dollars\nFlight income: " + this.getFlightInCome();


    }

    public int getFlightInCome() //calculate the income of single flight
    {
        return passengersBoard.size()*priceTicket;
    }


    public String printWorkersBoardForEditFlight() //fixed format to print vector workers.
    {
        String print = "";
        for(Worker w: workersBoard) {
            print += "Name : " + w.getFullName() + "\n" + "Id : " + w.getId() + "\n" + "Seniority : " + w.getSeniority() + "\n" + "\n";

        }
        return print;
    }

    public String printWorkersBoard() //another format to print vector workers - for GUI
    {
        String print = "";
        for(Worker p: workersBoard) {
            print += p.toString();
        }
        return print;
    }

    public int getPriceTicket() //returns the ticket price
    {
        return priceTicket;
    }


    public GregorianCalendar getFlightDate()  //return the flight date
    {
        return flightDate;
    }


    public boolean setPriceTicket(int priceTicket) //change the price per ticket
    {
        if(priceTicket>= 0) {
            this.priceTicket = priceTicket;
            return true;
        }
        else
            return false;
    }

    boolean isReadyToFlight() //checks whether a flight meets the threshold conditions for take-off
    {
        return workersBoard.size()>=10 && passengersBoard.size()+workersBoard.size() >= 0.75*numberOfSeats;
    }

    public int getFlightNumber() //returns the flight number
    {
        return flightNumber;
    }

    boolean isFull() //return boolean answer if still remains empty seats
    {
        return (passengersBoard.size()+workersBoard.size()) ==numberOfSeats;
    }

    boolean registerWorker (Worker w) //adding worker to vector workers
    {

        if(ExistInFlightByID(w.getId()))
        {
            return false;
        }
        workersBoard.add(w);
        return true;

    }
    boolean ExistInFlightByID(int id) //return boolean answer if there is anybody on flight with such id
    {
        for (Worker t: workersBoard)
        {
            if (t.getId() == id)
            {
                return true;
            }
        }
        for (Passenger p: passengersBoard)
        {
            if (p.getId() == id)
            {
                return true;
            }
        }
        return false;
    }

    boolean  registerPassenger (Passenger p) //adding passenger to vector passengers
    {
        if (isFull())
        {
            return false;
        }
        if(ExistInFlightByID(p.getId()))
        {
            return false;
        }
        passengersBoard.add(p);
        return true;
    }

    boolean removeWorker(int id) //remove worker by id
    {
       for (Worker t:workersBoard)
       {
           if (t.getId()==id)
           {
               workersBoard.remove(t);
               return true;
           }
        }
       return false;
   }

    boolean removePassenger (int id) //remove passenger by id
    {
        for (Passenger t:passengersBoard)
        {
            if (t.getId()==id)
            {
                passengersBoard.remove(t);
                return true;
            }
        }
        return false;
    }

    int numberOfSeatsAvailable() //return the number of remains seats on flight
    {
        return numberOfSeats - (passengersBoard.size()+workersBoard.size());
    }
}
