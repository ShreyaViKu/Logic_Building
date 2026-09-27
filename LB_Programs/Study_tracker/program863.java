/*
TreeMap
TreeMap <Integer, String>hobj = new TreeMap<Integer, String>();
treemap keys are sorted not in hashmap 
*/
import java.util.*;

class program863
{
    public static void main(String[] args)
    {
        TreeMap <Integer, String>hobj = new TreeMap<Integer, String>();

        hobj.put(20,"C programming");
        hobj.put(10,"JAVA programming");
        hobj.put(30,"C programming");

        System.out.println(hobj);

    }
}