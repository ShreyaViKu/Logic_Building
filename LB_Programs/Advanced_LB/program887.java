/*
Arrays.sort(Arr, Collections.reverseOrder());   for descending order
Integer class use as datatype in array
*/

import java.util.*;

class program887
{
    public static void main(String[] args)
    {
        Integer Arr[] = {10, 13, 34, 21, 15,7,24};

        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();

        Arrays.sort(Arr, Collections.reverseOrder());   
        
        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    
}
