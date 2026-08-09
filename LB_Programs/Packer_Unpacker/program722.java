/*
trim and replaceall double space to single space
*/
class program722
{
    public static void main(String[] args)
    {
        String header = "Hello.txt 1078";
        int size = 0;

        System.out.println("Actual header length : "+header.length());  // 14

        
        System.out.println("number of white spaces we need : "+ (100-header.length()));   // 92

        size = 100 - header.length();

        System.out.println("size variable is : "+size);

        for(int i = 1; i<= size;i++)
        {
            header = header + " ";
        }

        System.out.println("updated header length : "+header.length());
        System.out.println("updated header is : "+header);

    }
    
}
