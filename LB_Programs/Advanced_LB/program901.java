/*
Singly linear link list
InsertFirst
*/

import java.util.*;

class node
{
    public int data;
    public node next;

    public node(int iNo)
    {
        this.data = iNo;
        this.next = null;
    }
}

class SinglyLL
{
    public int iCount;
    public node first;

    public SinglyLL()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void InsertFirst(int iNo)
    {
        node newn = new node(iNo);

        if(this.first == null)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
            first = newn;
        }

        this.iCount++; 
    }

}
class program901
{
    public static void main(String[] args)
    {
        SinglyLL sobj = new SinglyLL();

        sobj.InsertFirst(51);
        sobj.InsertFirst(21);
        sobj.InsertFirst(11);
        
    }
}