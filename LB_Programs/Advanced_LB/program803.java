/*
problems on numbers breaking in digit
*/

import java.io.*;

class program803
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        System.out.println("Entered number is :"+iNo);

        int iDigit = 0;
        while(iNo != 0)
        {
            iDigit = iNo % 10;

            System.out.println(iDigit);

            iNo = iNo /10;
        }
        
    }
    
}
