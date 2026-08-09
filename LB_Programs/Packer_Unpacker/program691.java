/*
all files listed content copied from one folder to another file
*/
import java.io.*;
import java.util.*;

class program691
{
    public static void main(String[] args) throws Exception
    {
        Scanner sobj = new Scanner(System.in);
        String FolderName = null;
        String PackedFileName = null;
        int iRet = 0;

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

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

            byte Buffer[] = new byte[100];

            for(int i = 0; i <fArr.length; i++)
            {
                fiobj = new FileInputStream(fArr[i]);

                // loop to read from fiobj and write to foobj
                while((iRet = fiobj.read(Buffer)) != -1)
                {
                    foobj.write(Buffer,0,iRet);
                }
                fiobj.close();
                
            }
            foobj.close();

            System.out.println("Files packed successfully");
        }
        else
        {
            System.out.println("there is no such folder");
        }
    }
}