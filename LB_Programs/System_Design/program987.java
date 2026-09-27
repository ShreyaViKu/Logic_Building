/*
ParkingTicket pobj = new Builder()
        .setTicketNumber(11)
        .setVehicleNumber("MH12VL 9080")
        .setFloorNumber(4)
        .setSpotNumber(89)
        .setEntryTime("10.30 AM")
        .build();
*/

class ParkingTicket
{
    private int ticketNumber;
    private String vehicleNumber;
    private int floorNumber;
    private int spotNumber;
    private String entryTime;

    /*public ParkingTicket(int a, String b, int c, int d, String e)
    {
        this.ticketNumber = a;
        this.vehicleNumber = b;
        this.floorNumber = c;
        this.spotNumber = d;
        this.entryTime = e;
    }*/

    public ParkingTicket(Builder builder)
    {
        this.ticketNumber = builder.ticketNumber;
        this.vehicleNumber = builder.vehicleNumber;
        this.floorNumber = builder.floorNumber;
        this.spotNumber = builder.spotNumber;
        this.entryTime = builder.entryTime;
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

class Builder
{
    public  int ticketNumber;
    public String vehicleNumber;
    public int floorNumber;
    public int spotNumber;
    public String entryTime;

    public Builder setTicketNumber(int ticketNumber)
    {
        this.ticketNumber = ticketNumber;

        return this;
    }
    public Builder setVehicleNumber(String vehicleNumber)
    {
        this.vehicleNumber = vehicleNumber;

        return this;
    }
    public Builder setFloorNumber(int floorNumber)
    {
        this.floorNumber = floorNumber;

        return this;
    }
    public Builder setSpotNumber(int spotNumber)
    {
        this.spotNumber = spotNumber;

        return this;
    }
    public Builder setEntryTime(String entryTime)
    {
        this.entryTime = entryTime;

        return this;
    }
    public ParkingTicket build()
    {
        return new ParkingTicket(this);
    }

}

class program987
{
    public static void main(String[] args)
    {
        ParkingTicket pobj = new Builder()
        .setTicketNumber(11)
        .setVehicleNumber("MH12VL 9080")
        .setFloorNumber(4)
        .setSpotNumber(89)
        .setEntryTime("10.30 AM")
        .build();

        pobj.display();
    }
    
}
