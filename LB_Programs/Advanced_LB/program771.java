/*
HashMap Stirng character display with toarray
*/

import java.util.*;

class program771
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        // str = str.trim();
        char Arr[] = str.toCharArray();

        for(int i = 0; i< Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }
        
    }
}