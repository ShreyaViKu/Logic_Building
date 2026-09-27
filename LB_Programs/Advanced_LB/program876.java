/*
CheckSorted Array function
*/

import java.util.*;

import javax.xml.parsers.FactoryConfigurationError;

interface GetterSetter
{
    void Accept();
    void Display();
}

class ArrayX implements GetterSetter
{
    protected int Arr[];
    protected int iSize;

    public ArrayX(int iSize)
    {
        this.iSize = iSize;

        Arr = new int[iSize];
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the Elements of array : ");

        for(int i = 0; i < this.iSize; i++)
        {
            Arr[i] = sobj.nextInt();
        }
    }

    public void Display()
    {
        System.out.println("Elements of the array : ");

        for(int i = 0; i < this.iSize; i++)
        {
            System.out.print(Arr[i]+"\t");
        }
        System.out.println();
    }
}

final class Searching extends ArrayX
{
    public Searching(int iSize)
    {
        super(iSize);
    }

    public boolean LinearSearch(int iNo)
    {
        int i = 0;
        boolean bFlag = false;

        for(i = 0; i < this.iSize; i++)
        {
            if(this.Arr[i] == iNo)
            {
                bFlag = true;
                break;
            }
        }
        
        return bFlag;
    }

    public boolean BiDirectionalSearch(int iNo)
    {
        boolean bFlag = false;
        int iStart = 0, iEnd = 0;

        iEnd = super.iSize -1;

        while(iStart <= iEnd)
        {
            if(Arr[iStart] == iNo || Arr[iEnd] == iNo)
            {
                bFlag = true;
                break;
            }
            iStart++;
            iEnd--;
        }

        return bFlag;
    }

    public boolean CheckSorted()
    {
        boolean bFlag = true;

        int i = 0;

        for(i= 0; i < iSize-1; i++)
        {
            if(Arr[i] > Arr[i+1])
            {
                bFlag = false;
                break;
            }
        }

        return bFlag;
    }
}

class program876
{
    public static void main(String[] args)
    {
        Searching sobj = new Searching(5);

        sobj.Accept();
        sobj.Display();

        if(sobj.CheckSorted())
        {
            System.out.println("Array is Sorted");
        }
        else
        {
            System.out.println("Array is not Sorted");
        }
        
    }
}