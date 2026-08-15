/*
String key and integer value in hashmap
*/

import java.util.*;

class program779
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
        int iCount = 0;

        for(String s : Tokens)
        {
            if(hobj.containsKey(s))
            {
                iCount = hobj.get(s);
                hobj.put(s,iCount+1);
            }
            else
            {
                hobj.put(s, 1);
            }
        }
        System.out.println(hobj);
    }
}