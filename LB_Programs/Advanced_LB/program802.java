/*
problems on numbers using BufferedReader for input
Strong number or not
*/

import java.io.*;

class program802
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        System.out.println(iNo);
        
    }
    
}
