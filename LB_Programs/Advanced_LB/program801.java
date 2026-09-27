/*
Generic code for Matrix 
*/
import java.util.*;

class Matrix<T>
{
    protected int iRow;
    protected int iCol;
    protected T Arr[][];

    @SuppressWarnings("unchecked")
    public Matrix(int iRow, int iCol)
    {
        this.iRow = iRow;
        this.iCol = iCol;

        Arr = (T[][]) new Object[iRow][iCol];
    }

    @SuppressWarnings("unchecked")
    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the elements of matrix : ");

        for(int i = 0; i< iRow; i++)
        {
            for(int j = 0; j < iCol; j++)
            {
                Arr[i][j] = (T)sobj.next();
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
class program801
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter number of rows : ");
        int iRow = sobj.nextInt();

        System.out.println("Enter number of columns : ");
        int iCol = sobj.nextInt();

        Matrix <Double>mobj = new Matrix<Double>(iRow, iCol);

        mobj.Accept();
        mobj.Display();
        
    }
    
}
