/*
J3 update to upper
*/
import java.util.*;

class StringX
{
    public String toUpperX(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0;

        for(i = 0; i < Arr.length; i++)
        {
            
                Arr[i] = (char)(Arr[i] - 32);        // error
            
        }

        return new String(Arr);
    }
}

class program285
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String data = null;   
        String sRet = null; 

        System.out.println("enter string : ");
        data = sobj.nextLine();

        StringX strobj = new StringX();

        sRet = strobj.toUpperX(data);

        System.out.println("Updated string is : "+sRet);
        
    }
}