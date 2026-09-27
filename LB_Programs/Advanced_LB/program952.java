/*
LinkedHashMap 
stores key as we insert and main insertion order
*/

import java.util.*;

class program952
{
    public static void main(String[] A)
    {
        if(A.length != 1)
        {
            System.out.println("Invalid Number of arguments");
            return;
        }

        String str = A[0];

        LinkedHashMap <Character,Integer> frequency = new LinkedHashMap<Character, Integer>();

        for(char ch : str.toCharArray())
        {
            frequency.put(ch, frequency.getOrDefault(ch, 0)+1);
        }

        System.out.println(frequency);
    }
    
}
