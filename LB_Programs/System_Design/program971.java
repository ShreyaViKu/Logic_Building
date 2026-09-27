/*
Design patterns starting (Singlrton)
class Demo with private constructor so compilesd time error
*/

import javax.crypto.spec.DESKeySpec;

class Demo
{
    public int i , j;

    private Demo()
    {
        this.i = 0;
        this.j = 0;

        System.out.println("Object created");
    }
}

class program971
{
    public static void main(String[] args)
    {
        Demo obj1 = new Demo();

        Demo obj2 = new Demo();
    }   
    
}
