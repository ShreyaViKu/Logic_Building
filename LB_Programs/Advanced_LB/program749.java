/*
IP : my name is amit school name is abhinav city name is pune
OP : 3   // frequency of name 

*/

import java.util.*;

class program749
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;
        int iCount = 0;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+"," ");
        String Tokens[] = str.split(" ");

        for(int i = 0; i< Tokens.length; i++)
        {
            if(Tokens[i].equals("name"))
            {
                iCount++;
            }
            
        }

        System.out.println("Frequency of word is : "+iCount);
        
    }
}