/*
HashMap duplicate key not allowed so only once without error
*/

import java.util.*;

class program765
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <Character,Integer>hobj = new HashMap<Character,Integer>();

        hobj.put('a', 1);
        hobj.put('b', 1);
        hobj.put('a', 1);
        hobj.put('b', 1);

        System.out.println(hobj);
        
    }
}