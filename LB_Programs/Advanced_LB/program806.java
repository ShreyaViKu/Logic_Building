/*
factorial of number 
ulta loop
*/

import java.io.*;

class program806
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0, iFact = 0, i = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iFact = 1;
        for(i = iNo; i > 0; i--)
        {
            iFact = iFact * i;
        }
        
        System.out.println("Factorial is : "+iFact);
        
    }
    
}
