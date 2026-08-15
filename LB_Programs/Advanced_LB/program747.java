/*
IP : my name is amit
OP : ym eman si tima 
but tokenisation and concate stringbuilder
*/

import java.util.*;

class program747
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
        StringBuffer finalstr = new StringBuffer();

        for(int i = 0; i< Tokens.length; i++)
        {
            sb = new StringBuffer(Tokens[i]);

            finalstr.append(sb.reverse());
            finalstr.append(" ");
            
        }

        String output = new String(finalstr);

        output = output.trim();

        System.out.println("output = "+output);
        
    }
}