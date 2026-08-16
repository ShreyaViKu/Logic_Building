/*
palindrome number
reverse the number = original number
*/

import java.io.*;

class program822
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        int iDigit = 0, iTemp = 0, iRev = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        while(iNo != 0)
        {
            iDigit = iNo % 10;

            iRev = (iRev * 10) + iDigit;

            iNo = iNo /10;

        }
        
        if(iTemp == iRev)
        {
            System.out.println("number is palindrome number");
        }
        else
        {
            System.out.println("Number is not palindrome number");
        }
    }
    
}
