/*
anagram strings 
same character frequency jumbled
optimized due to one for for frequency 
*/

import java.util.*;

class program759
{
    public static boolean CheckAnagram(String str1, String str2)
    {
        boolean bFlag = true;
        int i = 0;

        if(str1.length() != str2.length())
        {
            return false;
        }

        str1 = str1.trim();
        str1 = str1.replaceAll("\\s+"," ");
        str1 = str1.toLowerCase();
        char Arr[] = str1.toCharArray();
        int Frequency1[] = new int[26];

        str2 = str2.trim();
        str2 = str2.replaceAll("\\s+"," ");
        str2 = str2.toLowerCase();
        char Brr[] = str2.toCharArray();
        int Frequency2[] = new int[26];

        for(i = 0; i< Brr.length; i++)
        {
            if(Arr[i] >= 'a' && Arr[i] <= 'z')
            {
                Frequency1[(int)Arr[i] - 97]++;
            }
            if(Brr[i] >= 'a' && Brr[i] <= 'z')
            {
                Frequency2[(int)Arr[i] - 97]++;
            }
        }
        
        for(i = 0; i< Frequency1.length; i++)
        {
            if(Frequency1[i] != Frequency2[i])
            {
                bFlag = false;
                break;
            }
        }
        return bFlag;
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