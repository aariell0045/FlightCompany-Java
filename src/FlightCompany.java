import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlightCompany //FlightCompany constructor
{
    private int companyNumber;
    private String name;
    private int FoundingYear;
    private Vector <Flight> Flights=new Vector<Flight>(0);
    private Vector <Worker> Workers=new Vector<Worker>(0);
    private Vector <saleTicket> sales=new Vector<saleTicket>(0);

    public String saleTicketsprint() // return a string of all sales made in the system
    {
        String s="";
        for(saleTicket t :sales)
        {
            s+=t.PrintSaleTicket() + "\n";
        }
        return  s;
    }
    public boolean AddSaleTicket(saleTicket t) //adding sale to sales vector
    {
        if(this.sales.contains(t))
        {
            return false;
        }
        else
        {
            this.sales.add(t);
            return true;
        }
    }
    public String saleTicketsToString() //return a string of all sales made in the system - toString format
    {
        String s="History sales :"+"\n"+sales.size()+"\n";
        for(saleTicket t :sales)
        {
            s+=t.toString() ;
        }
        return  s;
    }
    public boolean removesale(int flightNumber,int passangerId) //remove single sales from system
    {
        for(saleTicket e : sales)
        {
            if(e.getFlightNumber()==flightNumber && e.customer.getId()==passangerId)
            {
                sales.remove(e);
                return true;
            }
        }
        return false;
    }

    public String PrintWorkers()  //toString of workers vectror
    {
        String res = "";
        for (Worker w : Workers) {
            res = res + "Name : " + w.getFullName() + "\n" + "Id : " + w.getId() + "\n" + "Seniority : " + w.getSeniority() + "\n" + "\n";
        }
        return res;
    }

    public Vector<Flight> getFlights() //return the flights vector
    {
        return Flights;
    }

    public Vector<Worker> getWorkers() //return the workers vector
    {
        return Workers;
    }


    @Override
    public String toString() //FlightCompany toString
    {
        return "flight company:" +
                "\n" + companyNumber +
                "\n" + name +
                "\n" + FoundingYear +
                "\nflights:\n" +Flights.toArray().length + printFlights() +
                "\nworkers in company:\n" + Workers.toArray().length + printWorkers()+ "\n" +saleTicketsToString();
    }

    public String printFlights() //return string of flights
    {
        String print = "";
        for(Flight p: Flights) {
            print += p.toString();
        }
        return print;
    }


    public String showAllFlightDetails() //return all flights details of vector flights
    {
        String print="";
        for(Flight p: Flights)
        {
            print += p.showFlightDetails()+"\n\n";
        }
        return print;
    }

    public String printWorkers() //toString of vector workers
    {
        String print = "";
        for(Worker p: Workers) {
            print += p.toString();
        }
        return print;
    }

    public String getName() //return flight company name
    {
        return name;
    }

    public void setName(String name) //change flight company name
    {
        this.name = name;
    }

    public void setCompanyNumber(int companyNumber) //change flight company number
    {
        this.companyNumber = companyNumber;
    }

    public int getCompanyNumber() //return flight company number
    {
        return companyNumber;
    }

    public void setFoundingYear(int foundingYear) //change flight company founding year
    {
        FoundingYear = foundingYear;
    }

    public int getFoundingYear() //return flight company founding year
    {
        return FoundingYear;
    }

    Flight findFlight (int number) //return flight object of search by flight number
    {
        for (Flight f : Flights)
        {
            if (f.getFlightNumber()==number)
            {
                return f;
            }
        }
        return null;
    }

    int calcSingleIncome (Flight f) //return the income of single flight
    {
        return f.passengersBoard.size()*f.getPriceTicket();
    }

    int calcTotalIncome () //return the income of all the flights in flight company
    {
        int sum=0;
        for (Flight t: Flights)
        {
            sum += calcSingleIncome(t);
        }
        return sum;
    }

    boolean validateFlightNumber(int flightNumber) //check propriety input of flight number
    {
        return ( flightNumber>0 && findFlight(flightNumber)== null);
    }

    boolean addFlight (Flight f) //add flight to vector flights
    {
       if(!validateFlightNumber(f.getFlightNumber())) //if flight already exist
           return false;

        Flights.add(f);
        return true;


    }

    boolean removeFlight (Flight f) //remove flight from flights vector
    {
            if (f!=null)
            {
                Contact c;
                for (Passenger p: f.passengersBoard)
                {
                    c=new Contact(p,this,"Flight number " + f.getFlightNumber()+" has been canceled.");
                    c.sendToPassenger();
                }
                Flights.remove(f);
                return true;
            }
        return false;
    }

    private static String flightRemoved = ""; //collect string of all deleted flights

    String checkFlights () //check if flight fly in the next coming week and already sold 75% from the tickets
    {

        GregorianCalendar now = new GregorianCalendar();
        GregorianCalendar next7Days = new GregorianCalendar();
        next7Days.add(Calendar.DAY_OF_MONTH, 7);

        ExecutorService pool = Executors.newFixedThreadPool(this.Flights.size());
        Vector<Runnable> Tasks=new Vector<>(this.Flights.size());
        for (Flight t : Flights)
        {
            Tasks.add(()->checkSingleFlight(t,now,next7Days));
        }
        for(Runnable e :Tasks)
        {
            pool.execute(e);
        }
        pool.shutdown();
        while(!pool.isTerminated())
        {
        }
        return flightRemoved;
    }

    void checkSingleFlight (Flight f, GregorianCalendar now, GregorianCalendar next7Days) //check if flight fly in the next coming week and already sold 75% from the tickets
    {

        GregorianCalendar temp = f.flightDate;
        if (temp.before(now))
        {
            this.removeFlight(f);
            flightRemoved += f.getFlightNumber() + "\n";
        }
        if (temp.after(now) && temp.before(next7Days))
        {
            if (!f.isReadyToFlight())
            {
                this.removeFlight(f);
                synchronized (flightRemoved)
                {
                    flightRemoved += String.valueOf( f.getFlightNumber() + "\n");
                }

            }
        }
    }

    boolean addWorker(Worker w) //add worker to workers in company vector
    {
        if(findWorker(w.getId())==null)
        {
            Workers.add(w);
            return true;
        }
        return false;//already exist
    }

    boolean removeWorker(int id) //remove worker in company by id
    {
        Worker myWorker = findWorker(id);
        if (myWorker != null) {
            for (Flight fl : Flights) {
                if (fl.workersBoard.contains(myWorker)) {
                    fl.workersBoard.remove(myWorker);
                }
            }
            Workers.remove(myWorker);
            return true;
        }

        return false;
    }

    Worker findWorker(int id) //find worker by id, return object worker
    {
        for (Worker t : Workers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }


    }

