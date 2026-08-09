/*
unpacking code 
*/
import java.io.*;
import java.util.*;

class program733
{
    public static void main(String[] args) throws Exception
    {
        String PackFileName = null;
        String strHeader = null;
        int iRet = 0;

        Scanner sobj = new Scanner(System.in);
        File fpackobj = null;
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;
        File newfile = null;

        byte Header[] = new byte[100];
        String Tokens[] = null;
        byte Buffer[] = null;

        System.out.println("Enter name of packed file : ");
        PackFileName = sobj.nextLine();

        fpackobj = new File(PackFileName);

        if(fpackobj.exists())
        {
            fiobj = new FileInputStream(fpackobj);

            // read header
            while((iRet = fiobj.read(Header,0,100)) != -1)
            {
                strHeader = new String(Header);

                System.out.println("Header is : "+strHeader);

                strHeader = strHeader.trim();
                strHeader = strHeader.replaceAll("\\s+"," ");
                Tokens = strHeader.split(" ");

                System.out.println("File name : "+Tokens[0]);
                System.out.println("File size : "+Tokens[1]);

                newfile  = new File(Tokens[0]);
                newfile.createNewFile();

                foobj = new FileOutputStream(newfile);

                Buffer = new byte[Integer.parseInt(Tokens[1])];

                // read data
                fiobj.read(Buffer,0,Integer.parseInt(Tokens[1]));

                //write data
                foobj.write(Buffer,0,Integer.parseInt(Tokens[1]));

            }// end of while

        }
        else
        {
            System.out.println("there is no such pack file");
        }
        
    }
    
}
