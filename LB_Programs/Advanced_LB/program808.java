/*
factorial of number 
long integer in java 
*/

import java.io.*;

class program808
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0, i = 0;
        long iFact = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iFact = 1;
        while(iNo != 0)
        {
            iFact = iFact * iNo;
            iNo--;
        }
        
        System.out.println("Factorial is : "+iFact);
        
    }
    
}
