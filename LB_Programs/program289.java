/*
J3 update toggle
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
            if(Arr[i] >= 'a' && Arr[i] <= 'z')
            {
                Arr[i] = (char)(Arr[i] - 32);     
            }
        }

        return new String(Arr);
    }
    public String toLowerX(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0;

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] >= 'A' && Arr[i] <= 'Z')
            {
                Arr[i] = (char)(Arr[i] + 32);     
            }
        }

        return new String(Arr);
    }
    public String toggle(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0;

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] >= 'A' && Arr[i] <= 'Z')
            {
                Arr[i] = (char)(Arr[i] + 32);     
            }
            else if(Arr[i] >= 'a' && Arr[i] <= 'z')
            {
                Arr[i] = (char)(Arr[i] - 32);     
            }
        }

        return new String(Arr);
    }
}

class program289
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

        sRet = strobj.toLowerX(data);

        System.out.println("Updated string is : "+sRet);

        sRet = strobj.toggle(data);

        System.out.println("Updated string is : "+sRet);
        
    }
}