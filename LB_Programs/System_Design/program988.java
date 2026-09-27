/*

*/
class Demo
{
    public int i,j;

    public Demo fun()
    {
        return this;
    }
    public int gun()
    {
        return 11;
    }

}
class program988
{
    public static void main(String[] args)
    {
        Demo dobj = new Demo();

        int Ret = dobj.fun().gun();

        System.out.println(Ret);

    }    
}
