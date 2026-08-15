/*
IP : my name is amit
OP : ym eman si tima 
but tokenisation and printing word in reverse at new line
*/

import java.util.*;

class program745
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+"," ");
        String Tokens[] = str.split(" ");

        StringBuffer sb = null;

        for(int i = 0; i< Tokens.length; i++)
        {
            sb = new StringBuffer(Tokens[i]);
            System.out.println(sb.reverse());
        }
        
    }
}