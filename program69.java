
import java.util.Scanner;

class NumberX
{
   public boolean CheckPrime(int iNo)
   {
    // lOGIC 

    int iCnt = 0;
    boolean bFlag = false;

    //Multi Initialization in for loop
    for(bFlag = true, iCnt = 2; iCnt<= (iNo / 2); iCnt++)
    {
        if((iNo % iCnt) == 0)
        {
            bFlag = false;
            break;
        }
    }
    
    return bFlag;
   }
}

class program69
{
    
    public static void main(String A[])
    {
       Scanner sobj = new Scanner(System.in);

       int iValue = 0;

       System.out.println("Enter number : ");
       iValue = sobj.nextInt();

       NumberX nobj = new NumberX();

       boolean bRet = false;

       bRet= nobj.CheckPrime(iValue);

       if(bRet == true)
       {
        System.out.println("Number is Prime number ");
       }
       else
       {
        System.out.println("Number is not a Prime number ");
       }


    }
}

// Time Complexity : O(N/2)
// Where N>=0