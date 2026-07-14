/*
node creation in java with class and object creation
*/
class node
{
    public int data;
    public node next;
}
class program444
{
    public static void main(String A[])
    {
        node newn = null;     // newn reference created
        newn = new node();    // newn chya madhe address aala object cha node chya

        newn.data = 11;
        newn.next = null;

        System.out.println(newn.data);
        System.out.println(newn.next);
    }
}