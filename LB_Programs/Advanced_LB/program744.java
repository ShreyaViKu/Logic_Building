/*
reverse the string with inbuilt function
in stringbuffer as string does not have it inbuilt
sb.reverse print 
*/

import java.util.*;

class program744
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        StringBuffer sb = new StringBuffer(str);

        System.out.println(sb.reverse());
        
    }
}