/*
IP : my name is amit
OP : ym eman si tima 
OOP J3
*/

import java.util.*;

class StringX
{
    public String WordReverse(String str)
    {
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

        return output;
    }
}

class program748
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        StringX strobj = new StringX();

        String sret = strobj.WordReverse(str);

        System.out.println("output is : "+sret);
        
    }
}