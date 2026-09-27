/*
java program949.java 10 11
command line argument addition
*/

import java.util.*;

class program949
{
    public static void main(String[] A)
    {
        int ans = 0;

        if(A.length != 2)
        {
            System.out.println("Invalid Number of arguments");
            return;
        }

        //ans = A[0] + A[1];    ERROR

        System.out.println("Addition is : "+A[0] + A[1]);
    }
    
}
