import java.util.*;

class DigitX
{
    public int CountDigits(int iNo)
    {
        int iDigit = 0;
        int iCount = 0;

        for(; iNo> 0;iNo = iNo / 10)
        {
            
            iDigit = iNo % 10;
            iCount++;
        
        }
        return iCount;
    }
}
class program83
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

        System.out.println("Count of digits : "+iRet);
    }
}

//Time Complexity : O(N)