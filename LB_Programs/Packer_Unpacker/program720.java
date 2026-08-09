/*
trim and replaceall double space to single space
*/
class program720
{
    public static void main(String[] args)
    {
        String header = "A.txt 10";

        System.out.println("Actual header length : "+header.length());  // 8

        
        System.out.println("number of white spaces we need : "+ (100-header.length()));   // 92

    }
    
}
