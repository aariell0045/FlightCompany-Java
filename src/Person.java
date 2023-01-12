import java.util.Scanner;

abstract class Person // we dont want to crate a person object so its abstract
{
    private String fullName;
    private int id;
    private String Address;
    private String Gender;
    private String phoneNumber;

    public Person(String full_Name, int id, String Address, String Gender, String phone_Number)
    {
        this.setFullName(full_Name);
        this.id=id;
        this.Address=Address;
        this.Gender=Gender;
        phoneNumber=phone_Number;
    }
    public String getGender() {
        return Gender;
    }
    public String getAddress() {
        return Address;
    }
    public boolean setId(int id) {
        if (id >= 0) {
            this.id = id;
            return true;
        }
        return false;
    }

    public void setAddress(String address) {
        Address = address;
    }
    public Person(){};

    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }

    public boolean setFullName(String fullName) {
      if (fullName.length()>=3 && fullName.contains(" ")) // check if is name is bigger then 3 letters
       {
           this.fullName=fullName;
           return true;
       }

      return false;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {    //good for write to file
        return "" + fullName+
                "\n" + id +
                "\n" + Address +
                "\n" + Gender +
                "\n" + phoneNumber;
    }
}