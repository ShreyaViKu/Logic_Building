/*
File read typecast to char
*/
import java.io.*;
import java.util.*;

class program667
{
    public static void main(String[] args)
    {
        FileReader frobj = null;

        try 
        {
            frobj = new FileReader("Demo.txt");

            System.out.println((char)frobj.read());
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