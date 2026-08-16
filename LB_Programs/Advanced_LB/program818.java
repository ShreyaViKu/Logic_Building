/*
harshad number
sum of all digit is divisible by number itself
summ of all digits
*/

import java.io.*;

class program817
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        int iSum = 0, iDigit = 0, iTemp = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        while(iNo != 0)
        {
            iDigit = iNo % 10;
            iSum = iSum + iDigit;
            iNo = iNo / 10;
        }
        System.out.println("SUm of all digit is : "+iSum);

    }
    
}
