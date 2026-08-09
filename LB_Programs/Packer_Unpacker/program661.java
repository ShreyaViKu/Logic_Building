/*
File deletion
*/
import java.io.*;

class program661
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
                fobj.delete();
                System.out.println("File gets deleted");
            }   
            else
            {
                System.out.println("there is no such file");
            }  
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }
        

    }
}