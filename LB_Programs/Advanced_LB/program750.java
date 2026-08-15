/*
IP : india is my country i live in india
OP : bharat is my country i live in bharat   // replace

*/

import java.util.*;

class program750
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
            if(Tokens[i].equals("india"))
            {
                Tokens[i] = "bharat";
            }
            
        }

        System.out.println("output is : ");
        
    }
}