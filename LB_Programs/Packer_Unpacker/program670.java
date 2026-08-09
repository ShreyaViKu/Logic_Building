/*
File read with char Buffer array from read
frobj.read(Buffer,3,10);
*/
import java.io.*;
import java.util.*;

class program670
{
    public static void main(String[] args)
    {
        FileReader frobj = null;
        int iRet = 0;
        char Buffer[] = new char[20];

        try 
        {
            frobj = new FileReader("Demo.txt");

            frobj.read(Buffer,3,10);

            System.out.println(Buffer);
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