import java.io.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;



public class ReadWrite
{
    public static void main(String[] args) throws IOException
    {
        FlightCompany db = readingFromFile();
        writingToFile(db);
    }

    public static void writingToFile(FlightCompany db) throws java.io.IOException
    {
        try
        {
            File myObj = new File("flightCompanyDataBase.txt");
            FileWriter fw = null;
            if (!myObj.exists()) // check if exists or not, if not create a new file
            {
                if(!myObj.createNewFile()) throw new IOException("cant create new file");
            }
            else
            {
                fw = new FileWriter("flightCompanyDataBase.txt");
                fw.write(db.toString()); // write to file while using flight company toString function
                fw.close();
            }

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    public static FlightCompany readingFromFile() throws FileNotFoundException
    {
        FlightCompany db=new FlightCompany(); // db = data base
        File myObj = new File("flightCompanyDataBase.txt");
        if (!myObj.exists()) // check if exists or not, if not throw an error
        {
            throw new FileNotFoundException("Cannot open file, dosent exists");
        }
        Scanner sc = new Scanner(myObj);

        String stringReader;
        int intReader=0, i,j,k,h;
        int flightsReader=0, passengersReader=0 , messagesReader=0, workersReader=0;

        String day, month,year;

        while (sc.hasNextLine())
        {
            if (sc.nextLine().equals("flight company:")) // read all company details to filght company variables
            {
                db.setCompanyNumber(Integer.parseInt(sc.nextLine()));
                db.setName(sc.nextLine());
                db.setFoundingYear(Integer.parseInt(sc.nextLine()));
            }
            if (sc.nextLine().equals("flights:")) // read all flights details to filght variables
            {
                flightsReader=Integer.parseInt(sc.nextLine());
                // start a loop to read all the flights
                for (i=0; i<flightsReader ; i++)
                {
                    Flight flightTemp=new Flight();
                    flightTemp.setFlightNumber(Integer.parseInt(sc.nextLine()));

                    // read the date of the flight:
                    stringReader=sc.nextLine();
                    day=stringReader.charAt(0)+""+stringReader.charAt(1);
                    month=stringReader.charAt(3)+""+stringReader.charAt(4);
                    year=stringReader.charAt(6)+""+stringReader.charAt(7)+stringReader.charAt(8)+stringReader.charAt(9);
                    flightTemp.flightDate=new GregorianCalendar(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day));

                    // read all other variables of the flight:
                    flightTemp.setOrigin(sc.nextLine());
                    flightTemp.setDestination(sc.nextLine());
                    flightTemp.setNumberOfSeats(Integer.parseInt(sc.nextLine()));
                    flightTemp.setMaxBags(Integer.parseInt(sc.nextLine()));
                    flightTemp.setPriceTicket(Integer.parseInt(sc.nextLine()));

                    // read passangers of the flight:
                    if (sc.nextLine().equals("passengers:"))
                    {
                        passengersReader=Integer.parseInt(sc.nextLine());
                        // loop to read all passangers:
                        for (j=0; j<passengersReader ; j++)
                        {
                            Passenger passengerTemp=new Passenger(sc.nextLine(),Integer.parseInt(sc.nextLine()),sc.nextLine(), sc.nextLine(), sc.nextLine(),Boolean.parseBoolean(sc.nextLine()),Integer.parseInt(sc.nextLine()));
                            if (sc.nextLine().equals("messagesBox:"))
                            {
                                messagesReader=Integer.parseInt(sc.nextLine());
                                // loop to read all the messages box:
                                for (k=0; k<messagesReader ; k++)
                                {
                                    passengerTemp.addMessage(sc.nextLine());
                                }
                            }
                            flightTemp.registerPassenger(passengerTemp); // register the passanger to the flight
                        }
                    }
                    if (sc.nextLine().equals("workers on board:"))
                    {
                        workersReader=Integer.parseInt(sc.nextLine());
                        // loop to read all the workers on the flight:
                        for (h=0; h<workersReader ; h++)
                        {
                            Worker workerTemp = new Worker(sc.nextLine(),Integer.parseInt(sc.nextLine()),sc.nextLine(), sc.nextLine(), sc.nextLine(),Integer.parseInt(sc.nextLine()));
                            flightTemp.registerWorker(workerTemp);  // register the worker to the flight
                            db.addWorker(workerTemp);               // add the worker to our flight company
                        }
                    }

                    db.addFlight(flightTemp); // add the flight to the company array
                }

                // loop to add all the workers in the company:
                if (sc.nextLine().equals("workers in company:")) {
                    workersReader = Integer.parseInt(sc.nextLine());
                    for (h = 0; h < workersReader; h++) {
                        db.addWorker(new Worker(sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
                    }
                }
                // loop to add all the sales of the flight company and which passanger bought to which flight:
                if (sc.nextLine().equals("History sales :")) {
                    int numberofsales;
                    numberofsales = Integer.parseInt(sc.nextLine());
                    for (h = 0; h < numberofsales; h++) {
                        Flight f = db.findFlight(Integer.parseInt(sc.nextLine()));              // find the flight
                        Passenger p = f.FindPassangerOnBoard(Integer.parseInt(sc.nextLine()));  // find the passangers
                        //date:
                        stringReader = sc.nextLine();
                        day = stringReader.charAt(0) + "" + stringReader.charAt(1);             // write the date of the sale ticket
                        month = stringReader.charAt(3) + "" + stringReader.charAt(4);
                        year = stringReader.charAt(6) + "" + stringReader.charAt(7) + stringReader.charAt(8) + stringReader.charAt(9);
                        GregorianCalendar saleDate = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
                        if (f != null && p != null)
                            db.AddSaleTicket(new saleTicket(f, p, saleDate));
                    }
                }
            }



        }

        return db;
    }
    }