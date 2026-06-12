/*
IP   7
OP   A  *  B  *  C  *  D
     1  2  3  4  5  6  7

     48 0
     65 A
     97 a
     
 */
import java.util.*;

class program184
{
    public static void Display(int iNo)
    {
        int iCnt = 1;
        char ch = '\0';

       for(iCnt = 1, ch = 'A'; iCnt <= iNo; iCnt++)
        {
            if(iCnt % 2 == 0)
            {
                System.out.print("*\t");
            }
            else
            {
                System.out.print(ch + "\t");
                ch++;
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
