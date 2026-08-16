/*
harshad number
from a range of number display all h number
*/

import java.io.*;

class program820
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0, i = 0;
        int iSum = 0, iDigit = 0;
        int iStart = 0, iEnd = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter Starting point : ");
        iStart = Integer.parseInt(bobj.readLine());

        System.out.println("Enter Ending point : ");
        iEnd = Integer.parseInt(bobj.readLine());

        System.out.println("Harshad numbers are :");

        for(i = iStart; i<= iEnd; i++)
        {
            iNo = i;

            while(iNo != 0)
            {
                iDigit = iNo % 10;
                iSum = iSum + iDigit;
                iNo = iNo / 10;
            }

            if(i % iSum == 0)
            {
                System.out.println(i);
            }
            iSum = 0;
        }
        

    }
    
}
