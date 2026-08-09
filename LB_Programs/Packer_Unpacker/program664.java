/*
File write with closing the file 
*/
import java.io.*;
import java.util.*;

class program664
{
    public static void main(String[] args) throws IOException
    {
        FileWriter fwobj = new FileWriter("Demo.txt");

        fwobj.write("Jay Ganesh...");

        fwobj.close();    // IMP

    }
}