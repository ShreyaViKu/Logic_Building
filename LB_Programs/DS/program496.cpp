/* 
DoublyLL Generic program
*/

#include<iostream>
using namespace std;

#pragma pack(1)
template <class T>
struct node
{
    T data;
    struct node<T> * next;
    struct node<T> * prev;
};

#pragma pack(1)
template <class T>
class DoublyLL
{
    private:
        struct node<T> * first;
        int iCount = 0;
    public:
        DoublyLL();
        void Display();
        int Count();
        void InsertFirst(T iNo);
        void InsertLast(T iNo);
        void InsertAtPos(T iNo, int iPos);
        void DeleteFirst();
        void DeleteLast();
        void DeleteAtPos(int iPos);

};

template <class T>
DoublyLL<T> :: DoublyLL()
{
    this->first = NULL;
    this->iCount = 0;
}

template <class T>
void DoublyLL<T> :: Display()
{
    struct node<T> * temp = this->first;
    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" | <=> ";
        temp = temp->next;
    }
    cout<<"NULL\n";
}
template <class T>
int DoublyLL<T> :: Count()
{
    return iCount;
}

template <class T>
void DoublyLL<T> :: InsertFirst(T iNo)
{
    struct node<T> * newn = NULL;
    newn = new struct node<T>;
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(this->first == NULL)
    {
        this->first = newn;
    }
    else
    {
        newn->next = this->first;
        this->first->prev = newn;
        this->first = newn;
    }
    this->iCount++;
}

template <class T>
void DoublyLL<T> :: InsertLast(T iNo)
{
    struct node<T> * newn = NULL;
    struct node<T> * temp = NULL;
    newn = new struct node<T>;
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(this->first == NULL)
    {
        this->first = newn;
    }
    else
    {
        temp = this->first;
        while(temp->next != NULL)
        {
            temp = temp->next;
        }
        newn->prev = temp;
        temp->next = newn;
    }
    this->iCount++;
}

template <class T>
void DoublyLL<T> :: InsertAtPos(T iNo, int iPos)
{
    int i = 0;
    struct node<T> * temp = NULL;
    struct node<T> * newn = NULL;

    if((iPos < 1) || (iPos > iCount+1))
    {
        cout<<"Invalid position\n";
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
        newn  = new struct node<T>;

        newn->data = iNo;
        newn->next = NULL;
        newn->prev = NULL;

        temp = this->first;

        for(i = 1; i < iPos-1; i++)
        {
            temp = temp->next;
        }
        newn->next = temp->next;
        temp->next->prev = newn;
        temp->next = newn;
        newn->prev = temp;

        this->iCount++;
    }
}

template <class T>
void DoublyLL<T> ::DeleteFirst()
{
    if(this->first == NULL)
    {
        return;
    }
    else if(this->first->next == NULL)
    {
        delete this->first;
        this->first = NULL;
    }
    else
    {
        this->first = this->first->next;
        delete this->first->prev;
        this->first->prev = NULL;
    }
    this->iCount--;
}

template <class T>
void DoublyLL<T> :: DeleteLast()
{
    struct node<T> * temp = NULL;

    if(this->first == NULL)
    {
        return;
    }
    else if(this->first->next == NULL)
    {
        delete this->first;
        this->first = NULL;
    }
    else
    {
        temp = this->first;
        while(temp->next->next != NULL)
        {
            temp = temp->next;
        }
        delete temp->next;
        temp->next = NULL;
    }
    this->iCount--;
}

template <class T>
void DoublyLL<T> :: DeleteAtPos(int iPos)
{
    int i = 0;
    struct node<T> * temp = NULL;
    struct node<T> * newn = NULL;

    if((iPos < 1) || (iPos > this->iCount))
    {
        cout<<"Invalid position\n";
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
        temp = this->first;

        for(i = 1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        temp->next = temp->next->next;
        delete temp->next->prev;
        temp->next->prev = temp;

        this->iCount--;
    }
}

int main()
{
    DoublyLL<double> dobj;

    int iChoice = 0;
    int iValue = 0;
    int iPosition =0;
    int iRet = 0;

    while(iChoice != 9)
    {
        cout<<"---------------------------------------------------\n";
        cout<<"1 : Insert at First Position \n";
        cout<<"2 : Insert at Last Position \n";
        cout<<"3 : Insert at Given Position \n";
        cout<<"4 : Delete at First Position \n";
        cout<<"5 : Delete at Last Position \n";
        cout<<"6 : Delete at Given Position \n";
        cout<<"7 : Display values in Linked List \n";
        cout<<"8 : Count values in Linked List \n";
        cout<<"9 : Terminate the application and exit \n";
        cout<<"---------------------------------------------------\n";
        cout<<"Enter your choice : \n";
        cin>>iChoice;

        switch(iChoice)
        {
            case 1:
                cout<<"Enter Value : \n";
                cin>>iValue;
                dobj.InsertFirst(iValue);
                break;
            
            case 2:
                cout<<"Enter Value : \n";
                cin>>iValue;
                dobj.InsertLast(iValue);
                break;

            case 3:
                cout<<"Enter Value : \n";
                cin>>iValue;
                cout<<"Enter Position : \n";
                cin>>iPosition;
                dobj.InsertAtPos(iValue, iPosition);
                break;

            case 4:
                dobj.DeleteFirst();
                break;

            case 5:
                dobj.DeleteLast();
                break;

            case 6:
                cout<<"Enter Position : \n";
                cin>>iPosition;
                dobj.DeleteAtPos(iPosition);
                break;

            case 7:
                cout<<"Elements of Linked List are : \n";
                dobj.Display();
                break;

            case 8:
                iRet = dobj.Count();
                cout<<"Number of Elements are : "<<iRet<<endl;
                break;

            case 9:
                cout<<"Thanks for using this Application\n";
                break;

            default:
                cout<<"Invalid option\n";
            
        }
    }

    return 0;
}