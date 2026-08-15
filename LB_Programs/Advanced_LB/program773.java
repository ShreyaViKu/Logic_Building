/*
for (char ch : Arr)
put each word in hashmap with value as its frequency
*/

import java.util.*;

class program773
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <Character,Integer>hobj = new HashMap<Character,Integer>();

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        // str = str.trim();
        char Arr[] = str.toCharArray();
        int i = 0;

        for(char ch : Arr)
        {
            if(hobj.containsKey(ch))
            {
                i = hobj.get(ch);
                hobj.put(ch, i+1);
            }
            else
            {
                hobj.put(ch, 1);
            }
            
        }
        System.out.println(hobj);
        
    }
}