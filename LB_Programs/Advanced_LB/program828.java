/*
automorphic number
number square 
square last digitd equal to number
*/

import java.io.*;

class program828
{
    public static void main(String[] args)throws Exception
    {
        int iNo = 0;
        int iTemp = 0, iSquare = 0;
        int iCount = 0;
        int iDen = 0;

        InputStreamReader iobj = new InputStreamReader(System.in);

        BufferedReader bobj = new BufferedReader(iobj);

        System.out.println("Enter number : ");
        iNo = Integer.parseInt(bobj.readLine());

        String strNo = String.valueOf(iNo);

        iCount = strNo.length();

        iSquare = iNo * iNo;

        String strSquare = String.valueOf(iSquare);

        if(strNo.endsWith(strNo))
        {
            System.out.println("it is automorphic number");
        }
        else
        {
            System.out.println("it is not automorphic number");
        }


        
    }
    
}
