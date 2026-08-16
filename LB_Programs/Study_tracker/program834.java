/*
 for (int No : aobj)
        {
            System.out.println(No);
        }
*/

import java.util.*;

class program834
{
    public static void main(String[] args)
    {
        ArrayList <Integer>aobj = new ArrayList<Integer>();

        aobj.add(11);
        aobj.add(21);
        aobj.add(51);
        aobj.add(101);
        aobj.add(51);

        for (int No : aobj)
        {
            System.out.println(No);
        }
    }
    
}
