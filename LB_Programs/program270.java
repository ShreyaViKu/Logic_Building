/*
J3 for capital letter in string frequency
*/
import java.util.*;

class StringX
{
    public int CountCapital(String str)
    {
        int i = 0,iCount = 0;

        for(i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
            {
                iCount++;
            }
        }
        return iCount;
        
    }
}

class program270
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
    }
}