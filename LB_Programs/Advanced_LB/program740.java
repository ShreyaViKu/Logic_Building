/*
IP : my name is amit
OP : My Name Is Amit   // camle case

IP : My name Is aMiT
OP : My Name Is Amit   // camle case

trial
*/

import java.util.*;

class program740
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;
        String temp = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        
        str = str.toLowerCase();

        System.out.println(str);

        
    }
}