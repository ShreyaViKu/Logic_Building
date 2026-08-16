/*
strong number 
*/

import java.io.*;

class program809
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0, i = 0, iTemp = 0, iDigit = 0;
        long iFact = 0, iSum = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iFact = 1;
        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;

            while(iDigit != 0)
            {
                iFact = iFact * iDigit;
                iDigit--;
            }
            iSum = iSum + iFact;
            iFact = 1;

            iNo = iNo /10;
        }

        if(iSum == iTemp)
        {
            System.out.println("number is strong number ");
        }
        else
        {
            System.out.println("number is not strong number ");
        }
        
    }
    
}
