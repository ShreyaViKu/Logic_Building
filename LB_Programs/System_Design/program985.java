/*
Display function in class ticket
*/

class ParkingTicket
{
    private int ticketNumber;
    private String vehicleNumber;
    private int floorNumber;
    private int spotNumber;
    private String entryTime;

    public ParkingTicket(int a, String b, int c, int d, String e)
    {
        this.ticketNumber = a;
        this.vehicleNumber = b;
        this.floorNumber = c;
        this.spotNumber = d;
        this.entryTime = e;
    }

    public void display()
    {
        System.out.println("Ticket Number : "+this.ticketNumber);
        System.out.println("Vehicle Number : "+this.vehicleNumber);
        System.out.println("Floor Number : "+this.floorNumber);
        System.out.println("Spot Number : "+this.spotNumber);
        System.out.println("Enrty Time : "+this.entryTime);
    }

}

public class program985
{
    public static void main(String[] args)
    {
        ParkingTicket p1 = new ParkingTicket(11, "MH12 VL7172",3,89,"9:30 AM");
        ParkingTicket p2 = new ParkingTicket(12, "MH14 VL7020",4,32,"9:50 AM");

        p1.display();
        p2.display();
    }
    
}
