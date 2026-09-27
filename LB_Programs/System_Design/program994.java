/*
Observer design pattern
*/

import java.util.*;

interface ParkingObserver
{
    void Update(int availableSpots);

}

class DisplayBoard implements ParkingObserver
{
    public void Update(int availableSpots)
    {
        System.out.println("DisplayBoard : "+availableSpots);
    }
}

class MobileApplication implements ParkingObserver
{
    public void Update(int availableSpots)
    {
        System.out.println("MobileApplication : "+availableSpots);
    }
}

class ParkingFloor
{
    private int availableSpots;

    public ParkingFloor(int availableSpots)
    {
        this.availableSpots = availableSpots;
    }
}

public class program994
{
    public static void main(String[] args)
    {
        ParkingFloor floor = new ParkingFloor(5);
    }
    
}
