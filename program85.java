import java.util.*;

class DigitX
{
    public int CountDigits(int iNo)
    {
        int iCount = 0;
        int iDigit = 0;

        while( iNo > 0)
        {
            iDigit = iNo % 10;

            if(iDigit == 7)
            {
                iCount++;
            }
            iNo = iNo / 10;
        }
        return iCount;
    }
}
class program85
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        DigitX dobj = new DigitX();

        int iValue = 0;
        int iRet = 0;

        System.out.println("Enter Number :");
        iValue = sobj.nextInt();

        iRet = dobj.CountDigits(iValue);

        System.out.println("Count of digit 7 : "+iRet);
    }
}

//Time Complexity : O(N)