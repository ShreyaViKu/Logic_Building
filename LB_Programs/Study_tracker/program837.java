/*
if(aobj.contains("Satara"))
*/

import java.util.*;

class program837
{
    public static void main(String[] args)
    {
        ArrayList <String>aobj = new ArrayList<String>();

        aobj.add("Pune");
        aobj.add("Mumbai");
        aobj.add("Satara");
        aobj.add("Nashik");
        aobj.add("Mumbai");

        if(aobj.contains("Satara"))
        {
            System.out.println("Contains satara in arraylist");
        }
        else
        {
            System.out.println("satara is not present in arraylist");
        }
    }
    
}
