/*
iRow = 4
iCol = 4

2  4  6  8  10
1  3  5  7  9
2  4  6  8  10
1  3  5  7  9


*/
import java.util.*;

class Pattern
{
    public void Display(int iRow, int iCol)
    {
        int i = 0, j = 0, iCnt = 0;

        for(i = 1; i <= iRow; i++)
        {
            if(i % 2 != 0)
            {
                for(j = 1, iCnt = 2; j <= iCol; j++, iCnt += 2)
                {
                    System.out.print(iCnt + "\t");
                }
            }
            else
            {
                for(j = 1, iCnt = 1; j <= iCol; j++, iCnt += 2)
                {
                    System.out.print(iCnt + "\t");
                }
            }
            System.out.println();
        }
    }
}
class program288X
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        int iValue1 = 0, iValue2 = 0;

        System.out.println("Enter number of Rows : ");
        iValue1 = sobj.nextInt();

        System.out.println("Enter number of Columns : ");
        iValue2 = sobj.nextInt();

        Pattern pobj = new Pattern();

        pobj.Display(iValue1, iValue2);

    }
}