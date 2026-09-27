/*
Singleton design pattern error for new
*/

class ParkingLot
{
    private static ParkingLot instance;

    private ParkingLot()
    {
        System.out.println("ParkingLot object gets created");
    }

    public static ParkingLot getInstance()
    {
        if(instance == null)
        {
            instance = new ParkingLot();
        }
        return instance;
    }
}

class program981
{
    public static void main(String[] args)
    {
        ParkingLot pobj1 = ParkingLot.getInstance();

        ParkingLot pobj2 = ParkingLot.getInstance();

        ParkingLot pobj3 = ParkingLot.getInstance();
    }   
    
}
