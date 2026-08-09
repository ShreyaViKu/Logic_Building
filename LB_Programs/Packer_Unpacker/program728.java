/*
Final packing code
*/
import java.io.*;
import java.util.*;

class program728
{
    public static void main(String[] args) throws Exception
    {
        Scanner sobj = new Scanner(System.in);
        String FolderName = null;
        String PackedFileName = null;
        int iRet = 0; 
        int size = 0;
        int i = 0,j = 0;
        String header = "";

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        byte Buffer[] = new byte[1024];
        byte bHeader[] = null;


        System.out.println("Enter folder name : ");
        FolderName = sobj.nextLine();

        System.out.println("Enter name of packed file name : ");
        PackedFileName = sobj.nextLine();

        File fobjfolder = new File(FolderName);

        if((fobjfolder.exists()) && (fobjfolder.isDirectory()))
        {
            System.out.println("Folder exists");

            File fobjpack = new File(PackedFileName);
            fobjpack.createNewFile();    // packed file gets created

            foobj = new FileOutputStream(fobjpack);

            File fArr[] = fobjfolder.listFiles();

            System.out.println("Number of files in folder : "+fArr.length);

            for(i = 0; i <fArr.length; i++)
            {
                fiobj = new FileInputStream(fArr[i]);

                header =header +  fArr[i].getName();
                header = header + " ";
                header = header + fArr[i].length();

                size = 100 - header.length();

                for(j =1; j<= size; j++)
                {
                    header = header + " ";
                }

                bHeader = header.getBytes();

                // write file name and size

                foobj.write(bHeader);

                // loop to read from fiobj and write to foobj
                while((iRet = fiobj.read(Buffer)) != -1)
                {

                    foobj.write(Buffer,0,iRet);
                }
                
                fiobj.close();
                header = "";
                
            }
            foobj.close();
            sobj.close();
            System.out.println("Files packed successfully in the folder");
        }
        else
        {
            System.out.println("there is no such folder");
        }
    }
}