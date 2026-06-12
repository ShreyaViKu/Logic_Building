/*
IP 7
OP 1  *  2  *  3  *  4
 */
import java.util.*;

class program177
{
    public static void Display(int iNo)
    {
        int iCnt = 1;
        int iCount = 1;

       for(iCnt = 1; iCnt <= iNo; iCnt++)
        {
            if(iCnt %2 == 0)
            {
                System.out.print("*\t");
            }
            else
            {
                System.out.print(iCount+"\t");
                iCount++;
            }
        }
        System.out.println();
    }
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iValue = 0;

        System.out.println("Enter number of elements : ");
        iValue = sobj.nextInt();

        Display(iValue);

    }
    
}
