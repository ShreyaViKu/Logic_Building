/*
Directory check but not file error
*/
import java.io.*;
import java.util.*;

class program686
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
        }
        else
        {
            System.out.println("there is no such folder");
        }
    }
}