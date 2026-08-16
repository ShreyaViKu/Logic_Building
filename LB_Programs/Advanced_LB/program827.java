/*
automorphic number
number square 
square last digitd equal to number
*/

import java.io.*;

class program827
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        int iTemp = 0, iSquare = 0;
        int iCount = 0;
        int iDen = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        iSquare = iNo * iNo;

        while(iNo != 0)
        {
            iCount++;
            iNo = iNo / 10;
        }

        iDen = (int)Math.pow(10, iCount);

        if(iTemp == iSquare % iDen)
        {
            System.out.println("Number is automorphic number");
        }
        else
        {
            System.out.println("Number is not automorphic number");
        }
        
    }
    
}
