/*
factorial of number 
*/

import java.io.*;

class program805
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0, iFact = 0, i = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iFact = 1;
        for(i = 1; i<= iNo; i++)
        {
            iFact = iFact * i;
        }
        
        System.out.println("Factorial is : "+iFact);
        
    }
    
}
