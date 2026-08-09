/*
tokenization but more than space inbetween words 
*/
class program711
{
    public static void main(String[] args)
    {
        String header = "india  is  my  country";

        String Arr[] = header.split(" ");
        System.out.println("number of words are : "+Arr.length);

        for(int i = 0; i< Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }
        
    }
    
}
