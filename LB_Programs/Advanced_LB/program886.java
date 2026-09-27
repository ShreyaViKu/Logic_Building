/*
Arrays class operations
Arrays.sort(Arr);
end toindex is not inclusive fromindex is inclusive
*/

import java.util.*;

class program886
{
    public static void main(String[] args)
    {
        int Arr[] = {10, 13, 34, 21, 15,7,24};

        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();

        Arrays.sort(Arr,2,5);    // end toindex is not inclusive fromindex is inclusive
        
        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    
}
