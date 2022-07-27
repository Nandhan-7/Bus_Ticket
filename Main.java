import java.util.*;


import java.util.Scanner;


class Register {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailId;
    private long phoneNo;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    @Override
    public String toString() {
        return "Register [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" +
            password + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
    }
}



class Bus
{
    private int busNo;
    private int capacity;
    private Boolean ac;
    Bus(int busNo,Boolean ac,int capacity)
    {
        this.busNo=busNo;
        this.capacity=capacity;
        this.ac=ac;
    }
    public int getBusNo() {
        return busNo;
    }
    public Boolean getAc() {
        return ac;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setAc(Boolean ac) {
        this.ac = ac;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void displayBusInfo()
    {
        System.out.println("\nBus No :"+busNo+"\nAc :"+ac+"\nTotal Capacity :"+capacity);
    } 

}
class Booking
{
    Scanner sc=new Scanner(System.in);
    String passengerName;
    int busNo;
    String date;
    Booking()
    {
        System.out.println("Enter name of the passenger :");
        passengerName=sc.next();
        System.out.println("Enter the Bus No :");
        busNo=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Date dd-mm-yyyy :");
        date=sc.nextLine();
    }
    public Boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus> buses)
    {
        int CapCount=0;
        for(Bus b:buses)
        {
            if(b.getBusNo()==busNo)
            {
                CapCount=b.getCapacity();
            }
        }
        int Booked=0;
        for(Booking b:bookings)
        {
            if(b.busNo==busNo && b.date.equals(date))
            {
                Booked++;
            }
        }
        // System.out.println(CapCount+" "+Booked);
        return Booked<CapCount?true:false;
    }
}
public class Bus_Ticket_Booking {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        ArrayList<Bus> buses=new ArrayList<Bus>();
        ArrayList<Booking> bookings=new ArrayList<Booking>();
        ArrayList<Register> reg=new ArrayList<Register>();
        buses.add(new Bus(1,true,1));
        buses.add(new Bus(2,false,50));
        buses.add(new Bus(3,true,48));
        Boolean check=true;
        Scanner scanner=new Scanner(System.in);
        while(check)
        {
            System.out.println("Click 1 Registeration\nClick 2 Login\nClick 3 Exit");
            int typeUser=sc.nextInt();
            if(typeUser==2)
            {
                int retry=1;
                while(retry==1)
                {
                        System.out.print("Enter user name : ");
                        String userName = scanner.nextLine();
            
                        System.out.print("Enter password : ");
                        String password = scanner.nextLine();
                        int flag=0;
                        for(Register r:reg)
                        {
                            if (r.getUserName().equals(userName) && r.getPassword().equals(password)) {
                                System.out.println(" User successfully logged-in.. ");
                                flag=1;
                                for(Bus b: buses)
                                {
                                    b.displayBusInfo();
                                }
                                break;
                            } 
                        }
                        if(flag==0) {
                            System.out.println(" In valid userName of password ");
                            System.out.println("Enter 1 to login again 2 to exit");
                            retry=sc.nextInt();
                        }
                    
                }
                
                int userOpt=1;
                while(userOpt==1)
                {
                    System.out.println("Enter 1 to Book 2 to Exit:");
                    userOpt=sc.nextInt();
                    if(userOpt==1)
                    {
                        Booking booking=new Booking();
                        if(booking.isAvailable(bookings,buses))
                        {
                            System.out.println("You are Booking is Confirmed");
                            bookings.add(booking);
                        }
                        else
                        {
                            System.out.println("Sorry.Bus is Full, Try another bus or date !");
                        }
                        
                    }
                }
            }
            else if(typeUser==1)
            {

                Register register = new Register();

                // try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Enter firstName : ");
                    String firstName = scanner.nextLine();
                    register.setFirstName(firstName);
        
                    System.out.print("Enter lastName : ");
                    String lastName = scanner.nextLine();
                    register.setLastName(lastName);
        
                    System.out.print("Enter userName : ");
                    String userName = scanner.nextLine();
                    register.setUserName(userName);
        
                    System.out.print("Enter password : ");
                    String password = scanner.nextLine();
                    register.setPassword(password);
        
                    System.out.print("Enter emailId : ");
                    String emailId = scanner.nextLine();
                    register.setEmailId(emailId);
        
                    System.out.print("Enter phoneNo : ");
                    long phoneNo = scanner.nextLong();
                    register.setPhoneNo(phoneNo);
                    reg.add(register);
                    System.out.println(register.toString());
                // }
            }
            else if(typeUser==3)
            {
                check=false;
            }
            else
            {
                System.out.println("Enter valid Option");
            }
        }
    }
}
