/*
take N numbers from user and return summation of elements using oop concepts
 */
import java.util.*;

class ArrayX
{
    private int iSize = 0;
    private int Arr[];

    public ArrayX()             // default constructor
    {
        iSize = 5;
        Arr =new int[iSize];

    }
    public ArrayX(int x)         // parametrized constructor
    {
        iSize = x;
        Arr =new int[iSize];
    }

    public void Accept(Scanner sobj)
    {
        int iCnt = 0;

        System.out.println("Enter elments of array : ");

        for(iCnt = 0; iCnt < Arr.length; iCnt++)
        {
            Arr[iCnt] = sobj.nextInt();
        }
    }
    public void Display()
    {
        int iCnt = 0;

        System.out.println("elments of array : ");

        for(iCnt = 0; iCnt < Arr.length; iCnt++)
        {
            System.out.println(Arr[iCnt]);
        }
    }
    public int Summation()
    {
        int iCnt = 0, iSum = 0;

        for(iCnt = 0; iCnt < Arr.length; iCnt++)
        {
            iSum += Arr[iCnt];
        }
        return iSum;
    }
}
class program170
{

    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the number of elements :");
        int iLength = sobj.nextInt();

        ArrayX aobj = new ArrayX(iLength);   

        aobj.Accept(sobj);
        aobj.Display();
        int iRet = aobj.Summation();

        System.out.println("Summation is : "+ iRet);

        sobj.close();

        aobj = null;

        System.gc();
    }
    
}
