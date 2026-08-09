/*
trim and replaceall double space to single space
problem with more than 2 spaces
*/
class program704
{
    public static void main(String[] args)
    {
        String header = "    india   is   my   country    ";
        System.out.println(header.length());

        header = header.trim();   
        System.out.println(header.length());

        header = header.replaceAll("  ", " ");
        System.out.println(header.length());

        header = header.replaceAll("  ", " ");
        System.out.println(header.length());

    }
    
}
