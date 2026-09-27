/*
Factory design pattern
default:
                throw new IllegalArgumentException("Invalid vehicle type");
*/

enum VehicleType
{
    BIKE,
    CAR,
    TRUCK
}

abstract class Vehicle
{
    private String number;

    public Vehicle(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return this.number;
    }

    public abstract void display();

}

class Bike extends Vehicle
{
    public Bike(String number)
    {
        super(number);
    }

    public void display()
    {
        System.out.println("Bike : "+getNumber());
    }
}

class Car extends Vehicle
{
    public Car(String number)
    {
        super(number);
    }

    public void display()
    {
        System.out.println("Car : "+getNumber());
    }
}

class Truck extends Vehicle
{
    public Truck(String number)
    {
        super(number);
    }

    public void display()
    {
        System.out.println("Truck : "+getNumber());
    }
}

class VehicleFactory
{
    public static Vehicle createVehicle(VehicleType type, String number)
    {
        switch (type)
        {
            case BIKE:
                return new Bike(number);

            case CAR:
                return new Car(number);

            case TRUCK:
                return new Truck(number);

            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}

class program980
{
    public static void main(String[] args)
    {
        Vehicle v1 = VehicleFactory.createVehicle(VehicleType.BIKE, "MH12VL9080");
        Vehicle v2 = VehicleFactory.createVehicle(VehicleType.CAR, "MH12WZ9080");
        Vehicle v3 = VehicleFactory.createVehicle(VehicleType.TRUCK, "MH12ML9080");

        v1.display();
        v2.display();
        v3.display();

    }       
    
}
