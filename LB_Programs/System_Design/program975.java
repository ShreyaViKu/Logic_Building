/*
Factory Design pattern 
Enum code
*/

enum VehicleType
{
    BIKE,
    CAR,
    TRUCK
}

class program975
{
    public static void main(String[] args)
    {
        VehicleType obj = VehicleType.CAR;

        System.out.println(obj);

        System.out.println(VehicleType.CAR);
    }   
    
}
