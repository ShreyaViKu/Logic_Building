
import java.util.Scanner;

class NumberX
{
   public int SumFactors(int iNo)
   {
    // lOGIC 

    int iCnt = 0;
    int iSum = 0;

    for(iCnt = 1; iCnt<= (iNo / 2); iCnt++)
    {
        if((iNo % iCnt) == 0)
        {
            iSum = iSum+iCnt;
        }
    }
    return iSum;

   }

}

class program49
{
    
    public static void main(String A[])
    {
       Scanner sobj = new Scanner(System.in);

       int iValue = 0;

       System.out.println("Enter number : ");
       iValue = sobj.nextInt();

       NumberX nobj = new NumberX();

       int iRet = 0;

       iRet= nobj.SumFactors(iValue);

       System.out.println("Summation of Factors is : "+iRet);

    }
}

// Time Complexity : O(N/2)
// Where N>=0