/*
File write with fileoutputstream
foobj.write(Data);  // Error
*/
import java.io.*;
import java.util.*;

class program678
{
    public static void main(String[] args) throws Exception
    {
        String Fname = null;
        File fobj = null;
        FileInputStream fiobj = null;
          
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter file name : ");
        Fname = sobj.nextLine();

        fobj = new File(Fname);

        fiobj = new FileInputStream(fobj);

        byte Arr[] = new byte[50];

        

        if(fobj.exists())
        {
            fiobj.read(Arr); 

            //String Data = Arr.toString();

            System.out.println(new String(Arr));
        }
        else
        {
            System.out.println("there is no such file");
        }

    }
}