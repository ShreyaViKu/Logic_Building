import java.util.*;

class DigitX
{
    public int SumEvenDigits(int iNo)
    {
        int iSumEven = 0;
        int iDigit = 0;

        while( iNo > 0)
        {
            iDigit = iNo % 10;

            if(iDigit % 2 == 0)
            {
                iSumEven+=iDigit;
            }

            iNo = iNo / 10;
        }
        return iSumEven;
    }
}
class program90
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;
        int iRet = 0;

        System.out.println("Enter Number :");
        iValue = sobj.nextInt();

        iRet = dobj.SumEvenDigits(iValue);

        System.out.println("Summation of Even digits : "+iRet);
    }
}

//Time Complexity : O(N)
