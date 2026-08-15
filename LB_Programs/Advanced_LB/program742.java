/*
IP : my name is amit
OP : My Name Is Amit   // camle case

IP : My name Is aMiT
OP : My Name Is Amit   // camle case

first word not changing
*/

import java.util.*;

class program742
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
            if(Arr[i] == ' ')
            {
                if(Arr[i+1] >='a' && Arr[i+1] <='z')
                {
                    Arr[i+1] = (char)(Arr[i+1] - 32);
                }
                
            }
        }
        String output = new String(Arr);

        System.out.println("updated string is : "+output);
        
    }
}