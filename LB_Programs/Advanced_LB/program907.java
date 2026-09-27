/*
rabbit tottoise
*/

import java.util.*;

import javax.swing.text.DefaultEditorKit.CutAction;

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
    private int iCount;
    private node first;

    public SinglyLL()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void InsertFirst(int iNo)
    {
        node newn = new node(iNo);

        newn.next = first;
        first = newn;

        this.iCount++; 
    }

    public void InsertLast(int iNo)
    {
        node newn = new node(iNo);
        node temp = null;

        if(this.first == null)
        {
            first = newn;
        }
        else
        {
            temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
        this.iCount++;
    }

    public int Count()
    {
        return this.iCount;
    }

    public void Display()
    {
        node temp = null;

        temp = first;

        while(temp != null)
        {
            System.out.print("| "+temp.data+" | -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Time = N + N/2
    public int MiddleElement()
    {
        int iCount = Count();
        int middle = iCount/2;
        node temp = first;
        int i = 0;

        for(i = 1; i <= middle; i++)
        {
            temp = temp.next;
        }
        return temp.data;
    }

    public int MiddleElementX()
    {
        node fast = first;
        node slow = first;

        while(fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

}
class program907
{
    public static void main(String[] args)
    {
        SinglyLL sobj = new SinglyLL();
        int iRet = 0;

        sobj.InsertFirst(51);
        sobj.InsertFirst(21);
        sobj.InsertFirst(11);
        sobj.InsertLast(101);
        sobj.InsertLast(111);
        
        sobj.Display();

        iRet = sobj.MiddleElementX();

        System.out.println("middle element is : "+iRet);
    }
}