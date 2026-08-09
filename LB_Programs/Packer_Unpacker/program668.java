/*
File read
*/
import java.io.*;
import java.util.*;

class program668
{
    public static void main(String[] args)
    {
        FileReader frobj = null;
        int iRet = 0;

        try 
        {
            frobj = new FileReader("Demo.txt");

            while((iRet = frobj.read()) != -1)
            {
                System.out.println((char)iRet);
            }
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