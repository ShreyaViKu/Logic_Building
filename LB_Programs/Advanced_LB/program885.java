/*
Arrays class operations
Arrays.sort(Arr);
*/

import java.util.*;

class program885
{
    public static void main(String[] args)
    {
        int Arr[] = {10, 13, 7, 21, 15};

        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();

        Arrays.sort(Arr);
        
        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    
}
