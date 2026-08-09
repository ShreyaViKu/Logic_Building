/*
File write with fileoutputstream
foobj.write(Data);  // Error
*/
import java.io.*;
import java.util.*;

class program672
{
    public static void main(String[] args)
    {
        String Fname = null;
        File fobj = null;
        FileOutputStream foobj = null;
          
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        Fname = sobj.nextLine();

        fobj = new File(Fname);

        foobj = new FileOutputStream(fobj);

        String Data = "Marvellous Infosystems";

        if(fobj.exists())
        {
            foobj.write(Data);  // Error
        }
        else
        {
            System.out.println("there is no such file");
        }

    }
}