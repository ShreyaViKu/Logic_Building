/*
DCL Generic program
*/
#include<iostream>
using namespace std;

#pragma pack(1)
template <class T>
struct node 
{
    T data;
    struct node *next;
    struct node * prev;
};

#pragma pack(1)
template <class T>
class DoublyCL
{
    private :
        struct node<T> * first;
        struct node<T> * last;
        int iCount;

    public :
        DoublyCL();

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
DoublyCL<T> :: DoublyCL()
{
    first = NULL;
    last = NULL;
    iCount = 0;
}

template <class T>
void DoublyCL<T> :: Display()
{
    struct node<T> * temp = NULL;
    if(this->first == NULL && this->last == NULL)
    {
        return;
    }
    temp = this->first;
    cout<<"<=>";
    do
    {
        cout<<"| "<<temp->data<<" | <=> ";
        temp = temp->next;
    } while (temp != this->first);
    cout<<endl;
}
template <class T>
int  DoublyCL<T> :: Count()
{
    return iCount;
}

template <class T>
void DoublyCL<T> :: InsertFirst(T iNo)
{
    struct node<T> * newn = NULL;
    newn = new struct node<T>;
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(this->first == NULL)
    {
        this->first = newn;
        this->last = newn;
    }
    else
    {
        newn->next = this->first;
        this->first->prev = newn;
        this->first = newn;
    }
    this->last->next = this->first;
    this->first->prev = this->last;
    this->iCount++;
}

template <class T>
void DoublyCL<T> :: InsertLast(T iNo)
{
    struct node<T> * newn = NULL;
    newn = new struct node<T>;
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(this->first == NULL)
    {
        this->first = newn;
        this->last = newn;
    }
    else
    {
        newn->prev = this->last;
        this->last->next = newn;
        this->last = newn;
    }
    this->last->next = this->first;
    this->first->prev = this->last;
    this->iCount++;
}

template <class T>
void DoublyCL<T> :: InsertAtPos(T iNo, int iPos)
{
    int i = 0;
    struct node<T>* newn = NULL;
    struct node<T>* temp = NULL;

    if((iPos < 1) || ( iPos > iCount+1))
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
        temp = this->first;
        newn = new struct node<T>;
        newn->data = iNo;
        newn->next = NULL;
        newn->prev = NULL;
        
        for(i= 1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        newn->next = temp->next;
        temp->next->prev = newn;
        newn->prev = temp;
        temp->next = newn;

        this->iCount++;
    }
}

template <class T>
void DoublyCL<T> :: DeleteFirst()
{
    if(this->first == NULL && this->last == NULL)
    {
        return;
    }
    else if(this->first == this->last)
    {
        delete this->first;
        this->first = NULL;
        this->last = NULL;
    }
    else
    {
        this->first = this->first->next;
        delete this->first->prev;
        this->first->prev = this->last;
        this->last->next = this->first;
    }
    this->iCount--;
}

template <class T>
void DoublyCL<T> ::  DeleteLast()
{
    if(this->first == NULL && this->last == NULL)
    {
        return;
    }
    else if(this->first == this->last)
    {
        delete this->first;
        this->first = NULL;
        this->last = NULL;
    }
    else
    {
        this->last = this->last->prev;
        delete this->last->next;
        this->last->next = this->first;
        this->first->prev = this->last;
    }
    this->iCount--;
}

template <class T>
void DoublyCL<T> :: DeleteAtPos(int iPos)
{
    int i = 0;
    struct node<T>* temp = NULL;

    if((iPos < 1) || ( iPos > iCount))
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
        for(i= 1; i<iPos-1; i++)
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
    DoublyCL<double> dobj;
    int iRet = 0;

    dobj.InsertFirst(51);
    dobj.InsertFirst(21);
    dobj.InsertFirst(11);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<endl;

    dobj.InsertLast(101);
    dobj.InsertLast(111);
    dobj.InsertLast(121);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<endl;

    dobj.DeleteFirst();

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<endl;

    dobj.DeleteLast();

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<endl;

    dobj.InsertAtPos(105,4);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<endl;

    dobj.DeleteAtPos(4);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Number of nodes are : "<<iRet<<endl;

    return 0;
}