/*
CheckLoop function using rabbit tortise 
lop present
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

    public boolean CheckLoop()
    {
        boolean bFlag = false;

        node fast = null;
        node slow = null;

        fast = first;
        slow = first;

        while((fast != null) && (fast.next != null))
        {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
            {
                bFlag = true;
                break;
            }
        }
        return bFlag;
    }

}
class program913
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
        sobj.InsertLast(121);
        sobj.InsertLast(151);

        node temp1 = null;
        node temp2 = null;

        temp1 = sobj.first;
        temp2 = sobj.first;

        temp1 = temp1.next.next;

        while(temp2.next != null)
        {
            temp2 = temp2.next;
        }

        temp2.next = temp1;  // Loop creation

        if(sobj.CheckLoop())
        {
            System.out.println("Loop Detected");
        }
        else
        {
            System.out.println("Loop is not there");
        }

    }
}