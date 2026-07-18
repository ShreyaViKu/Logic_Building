/*
Queue Generic program
*/

#include<iostream>
using namespace std;

#pragma pack(1)
template <class T>
struct node
{
    T data;
    struct node *next;
};

#pragma pack(1)
template <class X>
class Queue
{
    public :
        struct node<X> * first;
        int iCount;

        Queue();
        void Enqueue(X No);
        X Dequeue();
        void Display();
        int Count();
};

template <class A>
Queue<A> :: Queue()
{
    this->first = NULL;
    this->iCount = 0;
}

template <class X>
void Queue<X> :: Enqueue(X No)
{
    struct node<X> * newn = NULL;
    struct node<X> * temp = NULL;
    newn = new struct node<X>;

    newn->data = No;
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

template <class B>
B Queue<B> :: Dequeue()
{
    B Value = B();
    struct node<B> *temp = NULL;

    if(this->first == NULL)
    {
        cout<<"Queue is empty\n";
        return B();
    }
    else
    {
        temp = this->first;
        Value = this->first->data;

        this->first = this->first->next;

        delete temp;

        this->iCount--;

        return Value;
    }
}

template <class X>
void Queue<X> :: Display()
{
    struct node<X> * temp = NULL;

    temp = this->first;

    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" |\n";
        temp = temp->next;
    }
}

template <class X>
int Queue<X> :: Count()
{
    return this->iCount;
}

int main()
{
    Queue<double> qobj;
    double iRet = 0;

    qobj.Enqueue(11.45);
    qobj.Enqueue(21.34);
    qobj.Enqueue(51.45);
    qobj.Enqueue(101.55);
    qobj.Enqueue(111.23);

    qobj.Display();
    iRet = qobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    iRet = qobj.Dequeue();
    cout<<"Removed element is : "<<iRet<<endl;

    qobj.Display();
    iRet = qobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    return 0;
}