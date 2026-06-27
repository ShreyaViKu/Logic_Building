/*
using package 
*/
import java.util.*;
import Marvellous.program280;

class program277
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String data = null;    // reference

        int iRet = 0;

        System.out.println("enter string : ");
        data = sobj.nextLine();

        program280 strobj = new program280();      // Error due to wrong source file

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