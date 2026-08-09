/*
File creation with try 2 catch 
*/
import java.io.*;

class program656
{
    public static void main(String[] args)
    {
        try
        {
            File fobj = new File("Demo.txt");

            fobj.createNewFile();     
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }
        

    }
}