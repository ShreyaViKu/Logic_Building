/*
String key and integer value in hashmap
*/

import java.util.*;

class program778
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
            System.out.println(s);
        }
    }
}