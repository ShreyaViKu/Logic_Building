/*
File creation  =with throws
*/
import java.io.*;

class program655
{
    public static void main(String[] args) throws IOException
    {
        File fobj = new File("Demo.txt");

        fobj.createNewFile();     

    }
}