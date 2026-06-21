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

class program269
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        String data = null;    // reference

        System.out.println("enter string : ");
        data = sobj.nextLine();

        StringX strobj = new StringX();

        strobj.Display(data);
    }
}