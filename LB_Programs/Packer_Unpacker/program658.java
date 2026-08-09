/*
File creation if it does not exist 
*/
import java.io.*;

class program658
{
    public static void main(String[] args)
    {
        try
        {
            File fobj = new File("Demo.txt");

            if(fobj.exists())
            {
                System.out.println("File already present");
            }   
            else
            {
                fobj.createNewFile();
                System.out.println("File gets successfully created");
            }  
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