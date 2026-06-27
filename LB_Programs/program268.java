/*
J3 for Display the string
*/
import java.util.*;

class StringX
{
    public void Display(String str)
    {
        System.out.println("Received string is : "+str);
    }
}

class program268
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String str = null;    // reference

        System.out.println("enter string : ");
        str = sobj.nextLine();

        program280 strobj = new program280();

        strobj.Display(str);
    }
}