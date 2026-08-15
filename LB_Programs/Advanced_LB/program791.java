/*
OOP J3 mobj = null call finalize
dynamic matrix array 
*/

import java.util.*;

class Matrix
{
    public int Arr[][];

    public Matrix(int iRow, int iCol)
    {
        Arr = new int[iRow][iCol];
        System.out.println("inside matrix constructor");
    }

    protected void finalize()
    {
        Arr = null;
        System.gc();
        System.out.println("inside finalize method");
    }
}
class program791
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        int iRow = 0, iCol = 0;
        int i = 0, j = 0;

        System.out.println("Enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Enter number of columns : ");
        iCol = sobj.nextInt();

        Matrix mobj = new Matrix(iRow, iCol);

        mobj = null;
        System.gc();

        /*System.out.println("Enter the elements of matrix : ");

        for(i = 0; i< iRow; i++)
        {
            for(j = 0; j < iCol; j++)
            {
                Arr[i][j] = sobj.nextInt();
            }
        }

        System.out.println("elements of matrix : ");

        for(i = 0; i< iRow; i++)
        {
            for(j = 0; j < iCol; j++)
            {
                System.out.print(Arr[i][j]+"\t");
            }
            System.out.println();
        }*/


    }
}