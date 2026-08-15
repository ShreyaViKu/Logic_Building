/*
accept string from user 
count words in it using tokenisation
*/

import java.util.*;

class program734
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        String Tokens[] = str.split(" ");

        System.out.println("Number of words are : "+ Tokens.length);
        
    }
}