/*
string input from user 
*/

import java.util.*;

class program705
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;

        System.out.println("Enter String : ");
        str = sobj.nextLine();

        System.out.println("string is : "+str+" having length : "+str.length());

    }
    
}
