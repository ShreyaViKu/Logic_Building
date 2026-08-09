/*
File read bytes its ascii
*/
import java.io.*;
import java.util.*;

class program666
{
    public static void main(String[] args)
    {
        FileReader frobj = null;

        try 
        {
            frobj = new FileReader("Demo.txt");

            System.out.println(frobj.read());
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