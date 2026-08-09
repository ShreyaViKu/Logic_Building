/*
trim method for sting issue
*/
class program697
{
    public static void main(String[] args)
    {
        String header = "    india is my country    ";

        header = header.trim();    // Issue resolved

        System.out.println(header.length());

    }
    
}
