/*
SinglyLL Generic program
*/

#include<iostream>
using namespace std;

#pragma pack(1)
template <class T>
struct node
{
    T data;
    struct node * next;
};

#pragma pack(1)
template <class T>
class SinglyLL
{
    private:
        struct node<T> * first;
        int iCount;
    public:
        SinglyLL();
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
SinglyLL<T> :: SinglyLL()
{
    this->first = NULL;
    this->iCount = 0;

}

template <class T>
void SinglyLL<T> :: Display()
{
    struct node<T> * temp = NULL;
    temp = this->first;

    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" | -> ";
        temp = temp->next;
    }
    cout<<"NULL\n";
}

template <class T>
int SinglyLL<T> :: Count()
{
    return iCount;
}

template <class T>
void SinglyLL<T> :: InsertFirst(T iNo)
{
    struct node<T> * newn = NULL;
    newn = new struct node<T>;
    newn->data = iNo;
    newn->next = NULL;

    if(NULL == this->first)
    {
        this->first = newn;
    }
    else
    {
        newn->next = this->first;
        this->first = newn;
    }
    this->iCount++;
}

template <class T>
void SinglyLL<T> :: InsertLast(T iNo)
{
    struct node<T> * temp = NULL;
    struct node<T> * newn = NULL;

    newn = new struct node<T>;
    newn->data = iNo;
    newn->next = NULL;

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
        temp->next = newn;
    }
    this->iCount++;
}

template <class T>
void SinglyLL<T> :: InsertAtPos(T iNo, int iPos)
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
        temp = this->first;
        newn = new struct node<T>;
        newn->data = iNo;
        newn->next = NULL;
        
        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        newn->next = temp->next;
        temp->next = newn;

        this->iCount++;
    }
}

template <class T>
void SinglyLL<T> :: DeleteFirst()
{
    struct node<T> * temp = NULL;

    if(this->first == NULL)
    {
        return;
    }
    else if(this->first->next == NULL)
    {
        free(this->first);
        this->first = NULL;
    }
    else
    {
        temp = this->first;
        this->first = this->first->next;
        delete temp;
    }
    this->iCount--;
}

template <class T>
void SinglyLL<T> :: DeleteLast()
{
    struct node<T> * temp = NULL;
    
    if(this->first == NULL)
    {
        return;
    }
    else if(this->first->next == NULL)
    {
        free(this->first);
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
void SinglyLL<T> :: DeleteAtPos(int iPos)
{
    int i = 0;
    struct node<T> * temp = NULL;
    struct node<T> * target = NULL;

    if((iPos < 1) || (iPos > iCount))
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
        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        target = temp->next;
        temp->next = temp->next->next;
        delete target;

        this->iCount--;
    }
}

int main()
{
    SinglyLL<double> sobj;
    int iRet = 0;

    sobj.InsertFirst(51.2);
    sobj.InsertFirst(21.2);
    sobj.InsertFirst(11.2);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    sobj.InsertLast(101.2);
    sobj.InsertLast(111.2);
    sobj.InsertLast(121.2);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    sobj.DeleteFirst();

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    sobj.DeleteLast();

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    sobj.InsertAtPos(105.2,4);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    sobj.DeleteAtPos(4);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;
    
    return 0;
}