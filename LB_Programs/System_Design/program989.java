/*

*/
class Demo
{
    public int i,j;

    public Demo fun()
    {
        this.i = 11;
        return this;
    }
    public int gun()
    {
        return this.i;
    }

}
class program989
{
    public static void main(String[] args)
    {
        Demo dobj = new Demo();

        int Ret = dobj.fun().gun();

        System.out.println(Ret);

        System.out.println(dobj.i);

    }    
}
