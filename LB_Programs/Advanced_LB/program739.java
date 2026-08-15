/*
accept string from user 
 maximum lengthed word 
 without imax
*/

import java.util.*;

class program739
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
        String Tokens[] = str.split(" ");

        System.out.println("Number of words are : "+ Tokens.length);

        temp = Tokens[0];

        for(int i = 0; i < Tokens.length; i++)
        {
            if(Tokens[i].length() >= temp.length())
            {
                temp = Tokens[i];
            }
        }

        System.out.println("All words is : "+temp+" having length : "+temp.length());
        
    }
}