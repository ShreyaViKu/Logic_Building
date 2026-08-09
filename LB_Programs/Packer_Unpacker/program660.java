/*
File creation variable fobj bret outside try so scopr is good
*/
import java.io.*;

class program660
{
    public static void main(String[] args)
    {
        File fobj = null;

        boolean bret = false;

        try
        {
            fobj = new File("Demo.txt");

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