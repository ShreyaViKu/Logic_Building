/*
strong number 
most optimozed with factoral array from 0 to 9
*/

import java.io.*;

class program811
{
    public static void main(String[] args)throws Exception
    {
        int iFact[] = {1,1,2,6,24,120,720,5040,40320,362880};
        int iNo = 0, i = 0, iTemp = 0, iDigit = 0;
        long iSum = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;

            iSum = iSum + iFact[iDigit];

            iNo = iNo /10;

            if(iSum > iTemp)
            {
                break;
            }
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
