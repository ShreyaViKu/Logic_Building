/*
for(char c : hobj.keySet())
display each word in hashmap with value as its frequency
*/

import java.util.*;

class program774
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        HashMap <Character,Integer>hobj = new HashMap<Character,Integer>();

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        // str = str.trim();
        char Arr[] = str.toCharArray();
        int iCount = 0;

        for(char ch : Arr)
        {
            if(hobj.containsKey(ch))
            {
                iCount = hobj.get(ch);
                hobj.put(ch, iCount+1);
            }
            else
            {
                hobj.put(ch, 1);
            }
            
        }
        for(char cValue : hobj.keySet())
        {
            System.out.println(cValue+" occurs "+hobj.get(cValue)+ " times");
        }
        
    }
}