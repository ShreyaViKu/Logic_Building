/*
File write with fileoutputstream
foobj.write(Data);  // Error
*/
import java.io.*;
import java.util.*;

class program676
{
    public static void main(String[] args) throws Exception
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

        byte Arr[] = Data.getBytes();

        if(fobj.exists())
        {
            foobj.write(Arr);  
        }
        else
        {
            System.out.println("there is no such file");
        }

    }
}