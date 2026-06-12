/*
IP   11
OP   *  *  *  #  #  #  *  *  *  #  #
     1  2  3  4  5  6  7  8  9  10 11
     
 */
import java.util.*;

class program188
{
    public static void Display(int iNo)
    {
        int iCnt = 1, iCount = 1;
        char ch = '*';
        

       while(iCnt <= iNo)
       {
            for(iCount = 1;iCount <= 3; iCount++ )
            {
                System.out.print(ch+"\t");
                iCnt++;
            }
            if(ch == '*')
            {
                  ch = '#';
            }
            else
            {
                ch = '*';
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
