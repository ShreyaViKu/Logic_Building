/*
for (char ch : Arr)
 Stirng character display with toarray
*/

import java.util.*;

class program772
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sobj.nextLine();

        // str = str.trim();
        char Arr[] = str.toCharArray();

        for(char ch : Arr)
        {
            System.out.println(ch);
            
        }
        
    }
}