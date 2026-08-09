/*
File write with closing the file in try
*/
import java.io.*;
import java.util.*;

class program665
{
    public static void main(String[] args)
    {
        FileWriter fwobj = null;

        try 
        {
            fwobj = new FileWriter("Demo.txt");
            fwobj.write("Jay Ganesh...");
            fwobj.close();
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        finally
        {
               
        }

    }
}