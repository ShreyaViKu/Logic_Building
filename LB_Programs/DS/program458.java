/*
Singly circular linked list
*/
import java.util.*
;
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

class SinglyCL
{
    private node first;
    private node last;
    private int iCount;

    public SinglyCL()
    {
        this.first = null;
        this.last = null;
        this.iCount = 0;
    }

    public void Display()
    {
        if(this.first == null && this.last == null)
        {
            return;
        }
        else
        {
            node temp = this.first;
            do
            {
                System.out.print("| "+temp.data+" | -> ");
                temp = temp.next;
            }while(temp != this.first);
            System.out.println();
        }
        
    }

    public int Count()
    {
        return this.iCount;
    }

    public void InsertFirst(int iNo)
    {
        node newn = new node(iNo);

        if(this.first == null && this.last == null)
        {
            this.first = newn;
            this.last = newn;
        }
        else
        {
            newn.next = this.first;
            first = newn;
        }
        this.last.next = this.first;
        this.iCount++;

    }

    public void InsertLast(int iNo)
    {
        node newn = new node(iNo);

        if(this.first == null && this.last == null)
        {
            this.first = newn;
            this.last = newn;
        }
        else
        {
            this.last.next = newn;
            this.last = newn;
        }
        this.last.next = this.first;
        this.iCount++;
    }

    public void InsertAtPos(int iNo, int iPos)
    {
        int i = 0;
        node newn = new node(iNo);
        node temp = null;

        if((iPos < 1) || (iPos > iCount+1))
        {
            System.out.println("Invalid position");
            return;
        }

        if(iPos == 1)
        {
            InsertFirst(iNo);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(iNo);
        }
        else
        {
            temp = first;
            for(i= 1; i<iPos-1; i++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;

            this.iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(this.first == null && this.last == null)
        {
            return;
        }
        else if(this.first == this.last)
        {
            this.first = null;
            this.last = null;
        }
        else
        {
            this.first = this.first.next;
            last.next = first;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        node temp = null;

        if(this.first == null && this.last == null)
        {
            return;
        }
        else if(this.first == this.last)
        {
            this.first = null;
            this.last = null;
        }
        else
        {
            temp = first;
            while(temp.next != last)
            {
                temp = temp.next;
            }
            last = temp;
            last.next = first;
        }
        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        int i = 0;
        node temp = null;

        if((iPos < 1) || (iPos > iCount))
        {
            System.out.println("Invalid position");
            return;
        }

        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            temp = first;
            for(i= 1; i<iPos-1; i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;

            this.iCount--;
        }
    }
}

class program458
{
    public static void main(String A[])
    {
        int iChoice = 0, iValue = 0, iPosition = 0;

        Scanner sobj = new Scanner(System.in);

        SinglyCL scobj = new SinglyCL();

        while(iChoice != 9)
        {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("1. Display LinkedList");
            System.out.println("2. Count no of nodes in LinkedList");
            System.out.println("3. Insert at first position");
            System.out.println("4. Insert at LAst position");
            System.out.println("5. Insert at given position");
            System.out.println("6. Delete at first position");
            System.out.println("7. Delete at LAst position");
            System.out.println("8. Delete at Given position");
            System.out.println("9. terminate the application and exit");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Enter your choice : ");
            iChoice = sobj.nextInt();

            switch (iChoice)
            {
                case 1:
                    scobj.Display();
                    break;
                case 2:
                    System.out.println("Number of elements are : "+scobj.Count());
                    break;
                case 3:
                    System.out.println("Enter number : ");
                    iValue = sobj.nextInt();
                    scobj.InsertFirst(iValue);
                    break;
                case 4:
                    System.out.println("Enter number : ");
                    iValue = sobj.nextInt();
                    scobj.InsertLast(iValue);
                    break;
                case 5:
                    System.out.println("Enter number : ");
                    iValue = sobj.nextInt();
                    System.out.println("Enter position : ");
                    iPosition = sobj.nextInt();
                    scobj.InsertAtPos(iValue,iPosition);
                    break;
                case 6:
                    scobj.DeleteFirst();
                    break;
                case 7:
                    scobj.DeleteLast();
                    break;
                case 8:
                    System.out.println("Enter position : ");
                    iPosition = sobj.nextInt();
                    scobj.DeleteAtPos(iPosition);
                    break;
                case 9:
                    System.out.println("Thanks for using Shreya's Application !!!");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
                    
            }
        }
    }
}