/*
Hashtable name replaced by HashMap in code
*/

import java.util.*;

class program767
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        Hashtable <Character,Integer>hobj = new Hashtable<Character,Integer>();

        hobj.put('a', 1);
        hobj.put('b', 1);
        hobj.put('a', 2);
        hobj.put('b', 2);

        System.out.println(hobj);
        
    }
}