/*
File read with char Buffer array from read
*/
import java.io.*;
import java.util.*;

class program669
{
    public static void main(String[] args)
    {
        FileReader frobj = null;
        int iRet = 0;
        char Buffer[] = new char[10];

        try 
        {
            frobj = new FileReader("Demo.txt");

            frobj.read(Buffer);

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