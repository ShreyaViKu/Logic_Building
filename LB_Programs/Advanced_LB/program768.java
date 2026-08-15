/*
HashMap hobj.get('b')
*/

import java.util.*;

class program768
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <Character,Integer>hobj = new HashMap<Character,Integer>();

        hobj.put('a', 1);
        hobj.put('b', 1);
        hobj.put('a', 2);
        hobj.put('b', 2);

        System.out.println(hobj);

        System.out.println(hobj.get('b'));
        
    }
}