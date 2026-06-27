/*
J3 update A or a to _ in string
*/
import java.util.*;

class StringX
{
    public String Update(String str)
    {
        char Arr[] = str.toCharArray();

        int i = 0;

        for(i = 0; i < Arr.length; i++)
        {
            if(Arr[i] == 'a' || Arr[i] == 'A')
            {
                Arr[i] = '_';
            }
        }

        return new String(Arr);
    }
}

class program279
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String data = null;   
        String sRet = null; 

        System.out.println("enter string : ");
        data = sobj.nextLine();

        StringX strobj = new StringX();

        sRet = strobj.Update(data);

        System.out.println("Updated string is : "+sRet);
        
    }
}