/*
int index = Arrays.binarySearch(Arr, 21);
*/

import java.util.*;

class program888
{
    public static void main(String[] args)
    {
        Integer Arr[] = {10, 13, 34, 21, 15,7,24};

        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();

        int index = Arrays.binarySearch(Arr, 21);

        if(index >= 0)
        {
            System.out.println("Element is present");
        }
        else 
        {
            System.out.println("There no such element");
        }

        for (int i : Arr) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    
}
