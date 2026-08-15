/*
String key and integer value in hashmap
*/

import java.util.*;

class program777
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <String,Integer>hobj = new HashMap<String,Integer>();

        hobj.put("PPA",1);
        hobj.put("LB",1);
        hobj.put("PYTHON",1);
        hobj.put("LB",2);
        hobj.put("LSP",1);

        System.out.println(hobj);
    }
}