/*
File exist function
*/
import java.io.*;

class program657
{
    public static void main(String[] args)
    {
        try
        {
            File fobj = new File("Demo.txt");

            System.out.println(fobj.exists());     
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }
        

    }
}