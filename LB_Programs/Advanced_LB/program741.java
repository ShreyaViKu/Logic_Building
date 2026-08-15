/*
IP : my name is amit
OP : My Name Is Amit   // camle case

IP : My name Is aMiT
OP : My Name Is Amit   // camle case
*/

import java.util.*;

class program741
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        
        str = str.toLowerCase();

        char Arr[] = str.toCharArray();

        for(int i = 0; i<Arr.length;i++)
        {
            System.out.println(Arr[i]);
        }
        
    }
}