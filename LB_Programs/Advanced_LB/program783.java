/*
max occured word in string
*/

import java.util.*;

class program783
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <String,Integer>hobj = new HashMap<String,Integer>();

        System.out.println("Enter string : ");
        String str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+"," ");

        String Tokens[] = str.split(" ");

        for(String s : Tokens)
        {
            if(hobj.containsKey(s))
            {
                hobj.put(s,hobj.get(s)+1);
            }
            else
            {
                hobj.put(s, 1);
            }
        }

        int imax = 0;
        String temp = null;

        for(String svalue : hobj.keySet())
        {
            if(hobj.get(svalue) > imax)
            {
                imax = hobj.get(svalue);
                temp = svalue;
            }
        }
        System.out.println(temp+" occured max times in string ie "+imax);
    }
}