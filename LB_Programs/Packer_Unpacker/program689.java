/*
from directory all file name and length of files display
*/
import java.io.*;
import java.util.*;

class program689
{
    public static void main(String[] args) throws Exception
    {
        Scanner sobj = new Scanner(System.in);
        String FolderName = null;

        System.out.println("Enter folder name : ");
        FolderName = sobj.nextLine();

        File fobj = new File(FolderName);

        if((fobj.exists()) && (fobj.isDirectory()))
        {
            System.out.println("Folder exists");

            File fArr[] = fobj.listFiles();

            System.out.println("Number of files in folder : "+fArr.length);

            for(int i = 0; i <fArr.length; i++)
            {
                System.out.println(fArr[i].getName());
                System.out.println(fArr[i].length());
            }
        }
        else
        {
            System.out.println("there is no such folder");
        }
    }
}