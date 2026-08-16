/*
automorphic number
number square 
square last digitd equal to number
best apporach
*/

import java.io.*;

class program829
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

        iTemp = iNo;

        iSquare = iNo * iNo;

        while(iNo != 0)
        {
            if(iNo % 10 != iSquare % 10)
            {
                break;
            }
            iNo = iNo / 10;
            iSquare = iSquare / 10;

        }
        if(iNo == 0)
        {
            System.out.println("it is automorphic number");
        }
        else
        {
            System.out.println("it is not automorphic number");
        }
        
    }
    
}
