/*
System.out.println(hobj.firstKey());
        System.out.println(hobj.lastKey());
         System.out.println(hobj.firstEntry());
        System.out.println(hobj.lastEntry());
*/
import java.util.*;

class program865
{
    public static void main(String[] args)
    {
        TreeMap <Integer, String>hobj = new TreeMap<Integer, String>();

        hobj.put(20,"C programming");
        hobj.put(10,"JAVA programming");
        hobj.put(30,"C programming");

        System.out.println(hobj);

        System.out.println(hobj.firstKey());
        System.out.println(hobj.lastKey());

        System.out.println(hobj.firstEntry());
        System.out.println(hobj.lastEntry());

    }
}