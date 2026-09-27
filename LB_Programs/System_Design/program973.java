/*
ParkingLot class with private constructor
private static ParkingLot instance;
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

class program973
{
    public static void main(String[] args)
    {
        //ParkingLot pobj = new ParkingLot();   private constructor

        ParkingLot pobj1 = ParkingLot.getInstance();

        ParkingLot pobj2 = ParkingLot.getInstance();

        ParkingLot pobj3 = ParkingLot.getInstance();
    }   
    
}
