/*
File write which does not exist
writer will create file not write in it
*/
import java.io.*;
import java.util.*;

class program663
{
    public static void main(String[] args) throws IOException
    {
        FileWriter fwobj = new FileWriter("Demo.txt");

        fwobj.write("Jay Ganesh...");

    }
}