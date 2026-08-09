/*
tokenization of a sentence ito words
*/
class program712
{
    public static void main(String[] args)
    {
        String header = "india  is  my  country";

        header = header.trim();

        header = header.replaceAll("\\s+"," ");

        String Arr[] = header.split(" ");
        System.out.println("number of words are : "+Arr.length);

        for(int i = 0; i< Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }
        
    }
    
}
