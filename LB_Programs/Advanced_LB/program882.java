/*
 if(iNo < Arr[iStart] || iNo > Arr[iEnd])
        {
            return false;
        }
*/

import java.util.*;

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

    public boolean BinarySearch(int iNo)
    {
        boolean bFlag = false;
        int iStart = 0, iEnd = 0, iMid = 0;

        if(CheckSorted() == false)
        {
            return BiDirectionalSearch(iNo);
        }

        iEnd = iStart-1;
        iStart = 0;

        if(iNo < Arr[iStart] || iNo > Arr[iEnd])
        {
            return false;
        }

        while(iStart <= iEnd)
        {
            iMid = iStart + ((iEnd - iStart) / 2);

            if(Arr[iMid] == iNo || Arr[iStart] == iNo || Arr[iEnd] == iNo)
            {
                bFlag = true;
                break;
            }
            else if(iNo < Arr[iMid])
            {
                iEnd = iMid -1;
            }
            else if(iNo > Arr[iMid])
            {
                iStart = iMid + 1;
            }

        }

        return bFlag;
    }
}

class program882
{
    public static void main(String[] args)
    {
        Searching sobj = new Searching(7);

        sobj.Accept();
        sobj.Display();

        if(sobj.BinarySearch(35))
        {
            System.out.println("Element is present");
        }
        else
        {
            System.out.println("Element is not present");
        }
        
    }
}