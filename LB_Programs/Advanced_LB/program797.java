/*
MatrixLB extends Matrix class
SummationAll
*/

import java.util.*;

class Matrix
{
    protected int Arr[][];
    protected int iRow;
    protected int iCol;

    public Matrix(int iRow, int iCol)
    {
        this.iRow = iRow;
        this.iCol = iCol;

        Arr = new int[iRow][iCol];

        System.out.println("inside matrix constructor");
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the elements of matrix : ");

        for(int i = 0; i< iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                Arr[i][j] = sobj.nextInt();
            }
        }
    }

    public void Display()
    {
        System.out.println("elements of matrix : ");

        for(int i = 0; i< iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                System.out.print(Arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}

class MatrixLB extends Matrix
{
    public MatrixLB(int iRow, int iCol)
    {
        super(iRow,iCol);
    }

    public int SummationAll()
    {
        int iSum = 0;

        for(int i = 0; i< iRow; i++)
        {
            for(int j = 0; j< iCol; j++)
            {
                iSum = iSum + Arr[i][j];
            }
        }

        return iSum;
    }

}
class program797
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        int iRow = 0, iCol = 0;
        int i = 0, j = 0, iRet = 0;

        System.out.println("Enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Enter number of columns : ");
        iCol = sobj.nextInt();

        MatrixLB mobj = new MatrixLB(iRow, iCol);

        mobj.Accept();

        mobj.Display();

        iRet = mobj.SummationAll();

        System.out.println( "Summation of all elements ia "+iRet);

        mobj = null;
        System.gc();
    }
}