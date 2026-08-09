/*
File name from user and delete
*/
import java.io.*;
import java.util.*;

class program662
{
    public static void main(String[] args)
    {
        Scanner sobj = null;

        File fobj = null;

        boolean bret = false;

        String Fname = null;

        sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        Fname = sobj.nextLine();

        try
        {
            fobj = new File(Fname);

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