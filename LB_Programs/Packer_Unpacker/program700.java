/*
replaceAll method issue not initailse to header
*/
class program700
{
    public static void main(String[] args)
    {
        String header = "marvellous";

        System.out.println(header);

        header.replaceAll("l","L");   // issue

        System.out.println(header);


    }
    
}
