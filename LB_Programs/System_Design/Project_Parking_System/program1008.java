/*
    ParkingLot Autoamation System

    Step 1 : Create required enums
    Step 2 : Vehicle Hierarchy creation
    Step 3 : VehicleFactory creation (Factory Pattern)
    Step 4 : ParkingSpot Hirrarchy
    Step 5 : ParkingObserver class
    Step 6 : ParkingFloor class 
    Step 7 : ParkingDispalyBoard (Observer Pattern)
    Step 8 : ParkingStrategy Class (Strategy Pattern)
    Step 9 : PricingStrategy Class (Strategy Pattern)
    Step 10 : PaymentStrategy Class
    Step 11 : ParkingTicket Class
    Step 12 : EntryGate Class
    Step 13 : ExitGate Class
    Step 14 : ParkingLot Class (Singleton Pattern)
    Step 15 : Main class (Controller)

*/

import java.util.*;
import java.time.Duration;
import java.time.LocalDateTime;

/////////////////////////////////////////////////////////
// Step 1 : Create Enums
// It is used to create fixed constants which are required
// throughout the project
/////////////////////////////////////////////////////////

// Represents the diffrent types of vehicles supported by the project
enum VehicleType
{
    BIKE,
    CAR,
    TRUCK
}

// Represents diffrent types of parking spots
enum SpotType
{
    BIKE,
    CAR,
    TRUCK
}

// Represents the current state of parking ticket
enum TicketStatus
{
    ACTIVE,
    CLOSED
}

/////////////////////////////////////////////////////////
// Step 2 : Create Vehicle Class hierarchy
// It is used to create multiple types of classes which r
// represnets the types of vehicles
// Concepts : Abstraction , Inheritance, Polymorphism, Encapsulation
/////////////////////////////////////////////////////////

// Class which represnts a generic vehicle type
abstract class Vehicle
{
    // Abstracted (Hidden) characteristics of class

    private String vehicleNumber;

    private VehicleType vehicleType;

    // Parametrised constructor
    public Vehicle(String vehicleNumber, VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    // Concrete getter method
    public VehicleType getVehicleType()
    {
        return this.vehicleType;
    }

    // Concrete getter method
    public String getVehicleNumber()
    {
        return this.vehicleNumber;
    }

    // Every concrete class will provide its own defination
    public abstract void display();
} 

// Class which represnets the Vechile type as Bike
class Bike extends Vehicle
{
    // Parametrised constructor
    public Bike(String vehicleNumber)
    {
        // Calls Vechile class constructor
        super(vehicleNumber, VehicleType.BIKE);
    }

    // Method overriding
    @Override 
    public void display()
    {
        System.out.println("Bike : "+getVehicleNumber());
    }
}

// Class which represnets the Vechile type as Car
class Car extends Vehicle
{
    // Parametrised constructor
    public Car(String vehicleNumber)
    {
        // Calls Vechile class constructor
        super(vehicleNumber, VehicleType.CAR);
    }

    // Method overriding
    @Override 
    public void display()
    {
        System.out.println("Car : "+getVehicleNumber());
    }
}

// Class which represnets the Vechile type as Truck
class Truck extends Vehicle
{
    // Parametrised constructor
    public Truck(String vehicleNumber)
    {
        // Calls Vechile class constructor
        super(vehicleNumber, VehicleType.TRUCK);
    }

    // Method overriding
    @Override 
    public void display()
    {
        System.out.println("Truck : "+getVehicleNumber());
    }
}

/////////////////////////////////////////////////////////
// Step 3 : Create VehicleFActory Class
// It is used to centralsied the creation of vechile objects
// Concepts : Factory Design Pattern
/////////////////////////////////////////////////////////

class VehicleFactory
{
    // Creates and return the desired class object

    public static Vehicle creatVehicle(VehicleType type, String number)
    {
        switch(type)
        {
            case BIKE:
                return new Bike(number);

            case CAR:
                return new Car(number);

            case TRUCK:
                return new Truck(number);

            default:
                throw new IllegalArgumentException("Invalid Vehicle type");
        }
    }
}

/////////////////////////////////////////////////////////
// Step 4 : Create ParkingSpot Hierarchy
// It is used to create hierarchy of Parking Spots
// Concepts : Encapsulation, Abstraction, Inheritance, Polymorphism
/////////////////////////////////////////////////////////

abstract class ParkingSpot
{
    // Unique number for parking spot (Primary Key)
    private int spotNumber;

    // Type of parking spot
    private SpotType spotType;

    // Indaicates wheteher spot is currently occupied of not
    private boolean occupied;

    // Stores information about the vechicle
    private Vehicle vehicle;

    // Parametrised constructor
    public ParkingSpot(int spotNumber, SpotType spotType)
    {
        this.spotNumber = spotNumber;
        this.spotType = spotType;

        // Initialsed with default values
        this.occupied = false;
        this.vehicle = null;
    }

    public int getSpotNumber()
    {
        return this.spotNumber;
    }

    public SpotType getSpotType()
    {
        return this.spotType;
    }

    public boolean isOccupied()
    {
        return this.occupied;
    }

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    // It is used to park the vechicle
    public void parkVehicle(Vehicle vehicle)
    {
        if(this.occupied == true)
        {
            throw new RuntimeException("Parking spot is already occupied");
        }
        else
        {
            this.vehicle = vehicle;
            this.occupied = true;
        }
    }

    public Vehicle removeVehicle()
    {
        if(this.occupied == true)
        {
            Vehicle temp = vehicle;

            this.vehicle = null;
            this.occupied = false;

            return temp;
        }
        else
        {
            throw new RuntimeException("Parking spot is already empty");
        }
    }

    // This method decides whether we can park it in the spot or not
    public abstract boolean canFitVehicle(Vehicle vehicle);

    public void display()
    {
        System.out.println("Spot : "+spotNumber+ "["+ spotType+"]");
    
        if(this.occupied == true)
        {
            System.out.println("Occupied by : "+vehicle.getVehicleNumber());
        }
        else
        {
            System.out.println("Spot is available");
        }
    }
} // End of ParkingSpot class

class BikeSpot extends ParkingSpot
{
    public BikeSpot(int spotNumber)
    {
        super(spotNumber, SpotType.BIKE);
    }

    @Override 
    public boolean canFitVehicle(Vehicle vehicle)
    {
        if(vehicle.getVehicleType() == VehicleType.BIKE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

class CarSpot extends ParkingSpot
{
    public CarSpot(int spotNumber)
    {
        super(spotNumber, SpotType.CAR);
    }

    @Override 
    public boolean canFitVehicle(Vehicle vehicle)
    {
        if(vehicle.getVehicleType() == VehicleType.CAR)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

class TruckSpot extends ParkingSpot
{
    public TruckSpot(int spotNumber)
    {
        super(spotNumber, SpotType.TRUCK);
    }

    @Override 
    public boolean canFitVehicle(Vehicle vehicle)
    {
        if(vehicle.getVehicleType() == VehicleType.TRUCK)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

/////////////////////////////////////////////////////////
// Step 5 : ParkingObserver class
// It is used to automatically update display board when
// the parking availablity changes
// Concepts : Observer 
/////////////////////////////////////////////////////////

interface ParkingObserver
{
    void update();
}

/////////////////////////////////////////////////////////
// Step 6 : ParkingFloor class
// It is used to manage parking floor
// Concepts : Composition, ArrayList, Object Management
/////////////////////////////////////////////////////////

class ParkingFloor
{
    // Unique floor number
    private int floorNumber;

    // Collection of all parking spots
    private List<ParkingSpot> parkingSpots;

    // Collection of observers registered for the floor
    private List<ParkingObserver> observers;

    public ParkingFloor(int floorNumber)
    {
        this.floorNumber = floorNumber;

        this.parkingSpots = new ArrayList<>();

        this.observers = new ArrayList<>();
    }

    public int getFloorNumber()
    {
        return this.floorNumber;
    }

    public void addParkingSpot(ParkingSpot spot)
    {
        parkingSpots.add(spot);
    }

    public void addObserver(ParkingObserver observer)
    {
        observers.add(observer);
    }

    private void notifyObservers()
    {
        for(ParkingObserver observer : observers)
        {
            observer.update();
        }
    }

    // Method is going to search parking spot for a specific vehicle
    public ParkingSpot findAvailabSpot(Vehicle vehicle)
    {
        for(ParkingSpot spot: parkingSpots)
        {
            if(!spot.isOccupied() && spot.canFitVehicle(vehicle))
            {
                return spot;
            }
        }
        return null;
    }

    // Called when new vehicle gets called
    public void occupySpot(ParkingSpot spot, Vehicle vehicle)
    {
        // Allocate spot for vehicle
        spot.parkVehicle(vehicle);

        // Notify all observers for avalability of spots
        notifyObservers();
    }

    public void releaseSpot(ParkingSpot spot)
    {
        // Release spot
        spot.removeVehicle();

        // Notify all observers for avalability of spots
        notifyObservers();
    }

    public int getAvailableCount(SpotType type)
    {
        int count = 0;

        for(ParkingSpot spot : parkingSpots)
        {
            if(spot.getSpotType() == type && !spot.isOccupied())
            {
                count++;
            }
        }

        return count;
    }

    // Display all spots of a specific floor
    public void displayFloor()
    {
        System.out.println();

        System.out.println("Floor : "+floorNumber);

        for(ParkingSpot spot : parkingSpots)
        {
            spot.display();
        }
    }
}

/////////////////////////////////////////////////////////
// Step 7 : Create ParkingDisplayBoard class
// It is used to create a class which displays
// the parking status 

// Subject -> ParkingFloor
// Observer -> ParkingDisplayBoard

// Note : Any observer is going to observe the subject
// There will be multiple observers for one subject
// Concepts : Observer Design Pattern
/////////////////////////////////////////////////////////

class ParkingDisplayBoard implements ParkingObserver
{
    // Floor whose availability is displayed by this board
    private ParkingFloor floor;

    public ParkingDisplayBoard(ParkingFloor floor)
    {
        this.floor = floor;
    }

    // Automatically called whenever floor avalability changes
    @Override 
    public void update()
    {
        System.out.println();
        System.out.println("----------------Display Board------------");

        System.out.println("Floor : "+floor.getFloorNumber());
        System.out.println("Available Bike Spots : "+floor.getAvailableCount(SpotType.BIKE));
        System.out.println("Available Car Spots : "+floor.getAvailableCount(SpotType.CAR));
        System.out.println("Available Truck Spots : "+floor.getAvailableCount(SpotType.TRUCK));

        System.out.println("-----------------------------------------");
        System.out.println();
    }
}
// We can create new observers for same suject parkingfloor
/* 
    class ParkingWebsite implements ParkingObserver
    {
        public void update()
        {
        }
    }
*/ 

/////////////////////////////////////////////////////////
// Step 8 : Create ParkingStrategy class
// It is used to create a class ParkingStrategy 
// Which is responsible to decide parkingspot selection
// Concepts : Strategy Design Pattern
/////////////////////////////////////////////////////////

//Defines a common concepts for parking spot selection algorithm
interface ParkingStrategy
{
    ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}

// Selects the first Available ParkingSpot

class FirstAvailableParkingStrategy implements ParkingStrategy
{
    @Override 
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle)
    {
        // Iterate over all available floors
        for(ParkingFloor floor : floors)
        {
            ParkingSpot spot = floor.findAvailabSpot(vehicle);

            if(spot != null)
            {
                return spot;
            }
        }
        return null;
    }
}
/*
    class NearestAvailableParkingStrategy implements ParkingStrategy
    {
    }
*/
/////////////////////////////////////////////////////////
// Step 9 : Create PricingStrategy class class
// It is used to create a class PricingStrategy
// it keeps the pricing algorithm independent of exit logic
// Concepts : Strategy Design Pattern
/////////////////////////////////////////////////////////

interface PricingStrategy
{
    double calculatePrice(Vehicle vehicle, long hours);
}

class NormalPricingStrategy implements PricingStrategy
{
    @Override 
    public double calculatePrice(Vehicle vehicle, long hours)
    {
        if(hours <= 0)
        {
            hours = 1;
        }

        switch (vehicle.getVehicleType())
        {
            case BIKE :
                return hours * 20;

            case CAR:
                return hours * 50;

            case TRUCK :
                return hours * 100;
        
            default:
                return 0;
        }
    }
}

class WeekendPricingStrategy implements PricingStrategy
{
    @Override 
    public double calculatePrice(Vehicle vehicle, long hours)
    {
        if(hours <= 0)
        {
            hours = 1;
        }

        switch (vehicle.getVehicleType())
        {
            case BIKE :
                return hours * 40;

            case CAR:
                return hours * 100;

            case TRUCK :
                return hours * 200;
        
            default:
                return 0;
        }
    }
}

/////////////////////////////////////////////////////////
// Step 10 : Create PaymentStrategy class class
// It is used to create a class PaymentStrategy
// it supports different types of payment methods
// Concepts : Strategy Design Pattern
/////////////////////////////////////////////////////////

// Comman contract for all payments methods
interface PaymentStrategy
{
    void pay(double amount);
}

class UPIPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("UPI payment successfull : Rs. "+amount);
    }
}

class CardPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Card payment successfull : Rs. "+amount);
    }
}

class CashPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Cash payment successfull : Rs. "+amount);
    }
}
/////////////////////////////////////////////////////////
// Step 11 : Create ParkingTicket class 
// It is used to create one complete parking transcation
/////////////////////////////////////////////////////////

class ParkingTicket
{
    // Used for generating unique tickets
    private static int counter = 1000;

    // ticket number for unique ticket
    private int ticketNumber;

    // vehicle associated with the ticket
    private Vehicle vehicle;

    // floor on which vehicle is parked
    private ParkingFloor floor;

    // Actual spot on which vehicle is parked
    private ParkingSpot spot;

    // time at which vehicle arrived
    private LocalDateTime entryTime;

    // time at which vehicle exited from parking floor
    private LocalDateTime exitTime;

    // it maintains status of the ticket
    private  TicketStatus status;

    public ParkingTicket(   Vehicle vehicle,
                            ParkingFloor floor,
                            ParkingSpot spot
                        )
    {
        this.ticketNumber = ++counter;
        this.vehicle = vehicle;
        this.floor = floor;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    // Getter method for ticketnumber
    public int getTicketNumber()
    {
        return this.ticketNumber;
    }

    // Getter method for vehicle
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    // Getter method for parkingfloor
    public ParkingFloor getParkingFloor()
    {
        return this.floor;
    }

    // Getter method for parkingspot
    public ParkingSpot getSpot()
    {
        return this.spot;
    }

    // Getter method for entrytime
    public LocalDateTime getEntryTime()
    {
        return this.entryTime;
    }

    // Getter method for exitTime
    public LocalDateTime getExitTime()
    {
        return this.exitTime;
    }

    // Getter method for status
    public TicketStatus getStatus()
    {
        return this.status;
    }

    // Method gets called when vehicle is going out
    public void closeTicket()
    {
        this.exitTime = LocalDateTime.now();

        this.status = TicketStatus.CLOSED;
    }

    // calculate total number of hours vehicle parked
    public long calculateHours()
    {
        LocalDateTime endtime;

        if(exitTime == null)
        {
            endtime = LocalDateTime.now();
        }
        else
        {
            endtime = exitTime;
        }

        // Calculate the actual time 
        long minutes = Duration.between(entryTime, endtime).toMinutes();

        // Convert minutes to hours
        long hours = minutes / 60;

        if(minutes % 60 != 0)
        {
            hours++;
        }

        if(hours == 0)
        {
            hours = 1;
        }

        return hours;

    }

    // it will display complete ticket on screen
    public void displayTicket()
    {
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("----------------Parking Ticket-----------");
        System.out.println("-----------------------------------------");

        System.out.println("Ticket Number  : "+this.ticketNumber);
        System.out.println("Vehicle Number : "+this.vehicle.getVehicleNumber());
        System.out.println("Vehicle type   : "+this.vehicle.getVehicleType());
        System.out.println("Floor Number   : "+this.floor.getFloorNumber());
        System.out.println("Spot Number    : "+this.spot.getSpotNumber());
        System.out.println("Entry Time     : "+this.entryTime);
        System.out.println("Ticket Status  : "+this.status);

        System.out.println("-----------------------------------------");
        System.out.println();
    }
}

class program1008
{
    public static void main(String A[])
    {

    }
}