/*
employee attendence analyzer
 frequency.put(id, frequency.getOrDefault(id,0)+1);
*/

import java.util.*;

class program939
{
    public static void main(String[] args)
    {
        int Arr[] = {101,102,103,101,104,102,101,105,105};

        HashMap <Integer,Integer> frequency = new HashMap<Integer,Integer>();

        for (int id : Arr)
        {
            frequency.put(id, frequency.getOrDefault(id,0)+1);

        }

        for(Map.Entry<Integer, Integer>eobj : frequency.entrySet())
        {
            System.out.println(eobj.getKey() +" -> "+eobj.getValue());
        }
    }
    
}
