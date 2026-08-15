/*
IP : india is my country i live in india
OP : bharat is my country i live in bharat   // replace
finalstr = finalstr.append("bharat");

*/

import java.util.*;

class program751
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

        StringBuffer finalstr = new StringBuffer();

        for(int i = 0; i< Tokens.length; i++)
        {
            if(Tokens[i].equals("india"))
            {
                finalstr = finalstr.append("bharat");
                finalstr = finalstr.append(" ");
                continue;
            }
            finalstr = finalstr.append(Tokens[i]);
            finalstr = finalstr.append(" ");
            
        }

        String output = new String(finalstr);

        output = output.trim();

        System.out.println("output is : "+output);
        
    }
}