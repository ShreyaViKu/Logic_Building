/*
number of digit in a number
armstrong number
*/

import java.io.*;

class program815
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
        System.out.println("Number of digits are : "+iCount);

    }
    
}
