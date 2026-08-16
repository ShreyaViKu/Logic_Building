/*
ArrayList <String>aobj = new ArrayList<String>();
*/

import java.util.*;

class program836
{
    public static void main(String[] args)
    {
        ArrayList <String>aobj = new ArrayList<String>();

        aobj.add("Pune");
        aobj.add("Mumbai");
        aobj.add("Satara");
        aobj.add("Nashik");
        aobj.add("Mumbai");

        aobj.remove(4);

        for (String str : aobj)
        {
            System.out.println(str);
        }

        aobj.clear();

        System.out.println(aobj);
    }
    
}
