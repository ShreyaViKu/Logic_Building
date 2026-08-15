/*
accept string from user 
all maximum lengthed word 
*/

import java.util.*;

class program738
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;
        String temp = null;
        int imax = 0;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        String Tokens[] = str.split(" ");

        System.out.println("Number of words are : "+ Tokens.length);

        for(int i = 0; i < Tokens.length; i++)
        {
            if(Tokens[i].length() >= imax)
            {
                imax = Tokens[i].length();
                temp = Tokens[i];
            }
        }

        System.out.println("All words with maximum length : ");

        for(int i = 0; i < Tokens.length; i++)
        {
            if(Tokens[i].length() == imax)
            {
                System.out.println(Tokens[i]);
            }
        }
        
    }
}