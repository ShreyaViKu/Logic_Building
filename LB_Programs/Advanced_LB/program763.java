/*
anagram strings 
using sort inbuilt function
return (str1.equals(str2));
*/

import java.util.*;

class program763
{
    public static boolean CheckAnagram(String str1, String str2)
    {
        int i = 0;

        if(str1.length() != str2.length())
        {
            return false;
        }

        char Arr[] = str1.toCharArray();
        char Brr[] = str2.toCharArray();

        Arrays.sort(Arr);
        Arrays.sort(Brr);

        str1 = new String(Arr);
        str2 = new String(Brr);

        return (str1.equals(str2));
        
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