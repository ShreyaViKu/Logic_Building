/*
File write with fileoutputstream
str = new String(Buffer,0,iRet);
*/
import java.io.*;
import java.util.*;

class program684
{
    public static void main(String[] args) throws Exception
    {
        String FnameSrc = null;
        String FnameDest = null;
        int iRet = 0;
        File fobjsrc = null;
        File fobjdest = null;
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;
          
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter Source file name : ");
        FnameSrc = sobj.nextLine();

        System.out.println("Enter Destination file name : ");
        FnameDest = sobj.nextLine();

        fobjsrc = new File(FnameSrc);
        fobjdest = new File(FnameDest);

        fiobj = new FileInputStream(fobjsrc);
        foobj = new FileOutputStream(fobjdest);

        fobjdest.createNewFile();

        byte Buffer[] = new byte[100];

        if(fobjsrc.exists() && fobjdest.exists())
        {
            String str = null;

            while((iRet = fiobj.read(Buffer)) != -1)
            {
                foobj.write(Buffer,0,iRet);
                //str = new String(Buffer,0,iRet);    // IMP
                //Buffer = str.getBytes();
                //foobj.write(Buffer);
                //str = null;
            }

            fiobj.close();
            foobj.close();
        }
        else
        {
            System.out.println("there is no such file");
        }

    }
}