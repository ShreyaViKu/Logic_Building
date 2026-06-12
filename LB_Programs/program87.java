import java.util.*;

class DigitX
{
    public int CountOddDigits(int iNo)
    {
        int iCount = 0;
        int iDigit = 0;

        while( iNo > 0)
        {
            iDigit = iNo % 10;

            if(iDigit % 2 != 0)
            {
                iCount++;
            }
            iNo = iNo / 10;
        }
        return iCount;
    }
}
class program87
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;
        int iRet = 0;

        System.out.println("Enter Number :");
        iValue = sobj.nextInt();

        iRet = dobj.CountOddDigits(iValue);

        System.out.println("Count of Even digit : "+iRet);
    }
}

//Time Complexity : O(N)

// count no of odd digits 