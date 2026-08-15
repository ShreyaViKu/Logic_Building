/*
matrix array display normal 
*/

import java.util.*;

class program787
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        int Arr[][] = {{10,20,30},{40,50,60},{70,80,90}};

        int i = 0, j = 0;

        for(i = 0; i< Arr.length; i++)
        {
            for(j = 0; j < Arr[i].length; j++)
            {
                System.out.print(Arr[i][j]+"\t");
            }
            System.out.println();
        }

    }
}