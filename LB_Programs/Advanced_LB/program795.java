/*
Matricx class in marvellous package in matrix.jva file
*/

import java.util.*;
import Marvellous.Matrix;

class MatrixLB extends Matrix
{
    public MatrixLB(int iRow, int iCol)
    {
        super(iRow,iCol);
    }

}
class program795
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

        MatrixLB mobj = new MatrixLB(iRow, iCol);

        mobj.Accept();

        mobj.Display();

        mobj = null;
        System.gc();
    }
}