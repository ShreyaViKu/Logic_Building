/*
File creation Exception
*/
import java.io.*;

class program654
{
    public static void main(String[] args)
    {
        File fobj = new File("Demo.txt");

        fobj.createNewFile();      // Exception

    }
}