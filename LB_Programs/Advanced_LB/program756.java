/*
anagram strings 
same character frequency jumbled
template 

*/

import java.util.*;

class program756
{
    public static boolean CheckAnagram(String str1, String str2)
    {
        boolean bRet = false;

        

        return bRet;
    }

    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str1 = null;
        String str2 = null;
        int i = 0;

        System.out.println("Enter First String : ");
        str1 = sobj.nextLine();

        System.out.println("Enter Second String : ");
        str2 = sobj.nextLine();

        boolean bRet = false;

        bRet = CheckAnagram(str1, str2);

        if(bRet)
        {
            System.out.println("Strings are Anagram strings");
        }
        else
        {
            System.out.println("Strings are not Anagram strings");
        }
        
    }
}