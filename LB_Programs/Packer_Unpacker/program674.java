/*
byte Arr[] = Data.getBytes();
string to byte array conversion
*/
import java.io.*;
import java.util.*;

class program674
{
    public static void main(String[] args)
    {
        String Data = "Marvellous Infosystems";

        byte Arr[] = Data.getBytes();

        System.out.println(Data.length());
        System.out.println(Arr.length);

        for(int i = 0; i<Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }

    }
}