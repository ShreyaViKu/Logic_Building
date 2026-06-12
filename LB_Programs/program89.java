import java.util.*;

class DigitX
{
    public int SumDigits(int iNo)
    {
        int iSum = 0;
        int iDigit = 0;

        while( iNo > 0)
        {
            iDigit = iNo % 10;

            iSum += iDigit;

            iNo = iNo / 10;
        }
        return iSum;
    }
}
class program89
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;
        int iRet = 0;

        System.out.println("Enter Number :");
        iValue = sobj.nextInt();

        iRet = dobj.SumDigits(iValue);

        System.out.println("Summation of digits : "+iRet);
    }
}

//Time Complexity : O(N)
