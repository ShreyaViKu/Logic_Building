/*
first non repeating char in string
java program951.java programming    to run this
tREEMAP stores alphabatically 
*/

import java.util.*;

class program951
{
    public static void main(String[] A)
    {
        if(A.length != 1)
        {
            System.out.println("Invalid Number of arguments");
            return;
        }

        String str = A[0];

        TreeMap <Character,Integer> frequency = new TreeMap<Character, Integer>();

        for(char ch : str.toCharArray())
        {
            frequency.put(ch, frequency.getOrDefault(ch, 0)+1);
        }

        System.out.println(frequency);
    }
    
}
