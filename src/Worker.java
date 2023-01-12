import java.util.Scanner;

public class Worker extends Person
{
    private int Seniority;//In years

    public Worker (String full_Name, int id,String Address,String Gender, String phoneNumber, int Seniority)//create worker
    {
        super(full_Name,id,Address,Gender,phoneNumber);//using Person constructor
        this.setSeniority(Seniority);//using set for validate the input
    }

    public Worker(){};

    @Override
    public String toString() {//printing and will be useful for writing to file
        return "\n"+ super.toString() +
                "\n" + Seniority;

    }

    public boolean setSeniority(int seniority)//checking that number of years >=0
    {
        if(seniority>=0)
        {
            Seniority = seniority;
            return true;
        }else
            return false;

    }

    public int getSeniority()
    {
        return Seniority;
    }
}
