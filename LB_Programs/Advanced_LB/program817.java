/*
armstrong number
*/

import java.io.*;

class program817
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        int iCount = 0, iTemp = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        while(iNo != 0)
        {
            iCount++;
            iNo = iNo /10;
        }

        iNo = iTemp;
        int iDigit = 0;
        int iSum = 0;

        while(iNo != 0)
        {
            iDigit = iNo %10;

            iSum = iSum + (int)Math.pow(iDigit, iCount);

            iNo = iNo /10;
        }

        if(iSum == iTemp)
        {
            System.out.println("number is armstrong number");
        }
        else
        {
            System.out.println("Number is not armstrong number");
        }

    }
    
}
