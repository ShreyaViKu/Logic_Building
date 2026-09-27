/*
Design patterns starting (Singlrton)
class Demo with constructor
*/

import javax.crypto.spec.DESKeySpec;

class Demo
{
    public int i , j;

    public Demo()
    {
        this.i = 0;
        this.j = 0;

        System.out.println("Object created");
    }
}

class program970
{
    public static void main(String[] args)
    {
        Demo obj1 = new Demo();

        Demo obj2 = new Demo();
    }   
    
}
