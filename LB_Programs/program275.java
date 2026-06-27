/*
J3 for count of special symbols in string
*/
import java.util.*;

class StringX
{
    public int CountSamll(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0,iCount = 0;

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] >= 'a' && Arr[i] <= 'z')
            {
                iCount++;
            }
        }
        return iCount;  
    }

    public int CountCapital(String str)
    {
        int i = 0,iCount = 0;

        char Arr[] = str.toCharArray();

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] >= 'A' && Arr[i] <= 'Z')
            {
                iCount++;
            }
        }
        return iCount;  
    }
    public int CountDigits(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0,iCount = 0;

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] >= '0' && Arr[i] <= '9')
            {
                iCount++;
            }
        }
        return iCount;  
    }
    public int CountSpace(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0,iCount = 0;

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] == ' ')
            {
                iCount++;
            }
        }
        return iCount;  
    }
    public int CountSpecial(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0,iCount = 0;

        for(i = 0; i < Arr.length; i++)
        {
            if((Arr[i] >= '!' && Arr[i] <= '/') || (Arr[i] >= ':' && Arr[i] <= '@')||
               (Arr[i] >= '[' && Arr[i] <= '`')|| (Arr[i] >= '{' && Arr[i] <= '~') )
            {
                iCount++;
            }
        }
        return iCount;  
    }
}

class program275
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String data = null;    // reference

        int iRet = 0;

        System.out.println("enter string : ");
        data = sobj.nextLine();

        StringX strobj = new StringX();

        iRet = strobj.CountCapital(data);

        System.out.println("Capital characters are : "+ iRet);

        iRet = strobj.CountSamll(data);

        System.out.println("Small characters are : "+ iRet);

        iRet = strobj.CountDigits(data);

        System.out.println("Digits count are : "+ iRet);

        iRet = strobj.CountSpace(data);

        System.out.println("Spaces count are : "+ iRet);

        iRet = strobj.CountSpecial(data);

        System.out.println("Special symbols are : "+ iRet);
    }
}