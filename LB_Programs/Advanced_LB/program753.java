/*
count frequency of each word from a To z

*/

import java.util.*;

class program753
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;
        int i = 0;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+"," ");

        char Arr[] = str.toCharArray();

        int Frequency[] = new int[26];

        // a  b  c  d
        // 97  98  99
        // 0  1  2  3
        for(i = 0; i< Arr.length; i++)
        {
            if(Arr[i] >= 'a' && Arr[i] <= 'z')
            {
                Frequency[(int)Arr[i] - 97]++;
            }
        }

        System.out.println("Frequency of each letter is : ");

        for(i = 0; i < Frequency.length; i++)
        {
            System.out.println((char)(i+97) +" : "+Frequency[i]);
        }
        
    }
}