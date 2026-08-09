/*
trim and replaceall double space to single space
*/
class program703
{
    public static void main(String[] args)
    {
        String header = "    india   is   my   country    ";
        System.out.println(header.length());

        header = header.trim();   
        System.out.println(header.length());

        header = header.replaceAll("  ", " ");
        System.out.println(header.length());

    }
    
}
