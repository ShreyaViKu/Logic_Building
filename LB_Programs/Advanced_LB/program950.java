/*
ans = Integer.parseInt(A[0]) + Integer.parseInt(A[1]) ;  
*/

import java.util.*;

class program950
{
    public static void main(String[] A)
    {
        int ans = 0;

        if(A.length != 2)
        {
            System.out.println("Invalid Number of arguments");
            return;
        }

        ans = Integer.parseInt(A[0]) + Integer.parseInt(A[1]) ;  

        System.out.println("Addition is : "+ans);
    }
    
}
