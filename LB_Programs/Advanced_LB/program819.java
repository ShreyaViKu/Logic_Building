/*
harshad number
sum of all digit is divisible by number itself
*/

import java.io.*;

class program819
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        int iSum = 0, iDigit = 0, iTemp = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            iSum = iSum + iDigit;
            iNo = iNo / 10;
        }

        if(iTemp % iSum == 0)
        {
            System.out.println("Number is harshad number");
        }
        else
        {
            System.out.println("number is not harshad number");
        }

    }
    
}
