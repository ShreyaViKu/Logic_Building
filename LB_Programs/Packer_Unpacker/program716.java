/*
void DisplayWords(String str) from class StringX 
with word length
*/

import java.util.*;

class StringX
{
    int CountWords(String str)
    {
        str = str.trim();

        str = str.replaceAll("\\s+"," ");

        String Tokens[] = str.split(" ");

        return Tokens.length;
    }

    void DisplayWords(String str)
    {
        str = str.trim();

        str = str.replaceAll("\\s+"," ");

        String Tokens[] = str.split(" ");

        for(int i = 0; i< Tokens.length; i++)
        {
            System.out.println(Tokens[i] + " : "+Tokens[i].length());
        }
    }

    void LargestWord(String str)
    {
        int imax = 0;

        str = str.trim();

        str = str.replaceAll("\\s+"," ");

        String Tokens[] = str.split(" ");

        for(int i = 0; i< Tokens.length; i++)
        {
            if(Tokens[i].length() > imax)
            {
                imax = Tokens[i].length();
            }
            
        }
        System.out.println("largest word length is "+imax);
    }

    
}
class program716
{
    public static void main(String[] args)
    {
        StringX strobj = new StringX();
        int iRet = 0;

        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        strobj.LargestWord(str);

    }
    
}
