/*
automorphic number
number square 
square last digitd equal to number
*/

import java.io.*;

class program823
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        int iDigit = 0, iTemp = 0, iSquare = 0;
        int iCount = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        iTemp = iNo;

        iSquare = iNo * iNo;

        while(iNo != 0)
        {
            iCount++;
            iNo = iNo / 10;
        }
        
    }
    
}
