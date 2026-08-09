/*
trim and replaceall double space to single space
*/
class program719
{
    public static void main(String[] args)
    {
        String header = "A.txt 10";

        System.out.println(header.length());  // 8

        header = header +" ";
        header = header +" ";
        header = header +" ";
        System.out.println(header.length());   // 11

    }
    
}
