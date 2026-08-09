/*
File creation if it does not exist with bret variable
*/
import java.io.*;

class program659
{
    public static void main(String[] args)
    {
        try
        {
            boolean bret = false;

            File fobj = new File("Demo.txt");

            bret = fobj.exists();

            if(bret == true)
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