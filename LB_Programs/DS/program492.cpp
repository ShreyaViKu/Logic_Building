/*
Stack generic program with template
*/
#include<iostream>
using namespace std;

#pragma pack(1)
template <class T>
struct node
{
    T data;
    struct node<T> * next;
};

template <class T>
class Stack
{
    private :
        struct node<T> * first;
        int iCount;
    public:
        Stack();
        void push(T iNo);      // InsertFirst
        T pop();               // DeleteFirst
        T peep();              // DeleteFirst sarkh
        void Display();
        int Count();
};

template <class T>
Stack<T> :: Stack ()
{
    this->first = NULL;
    this->iCount = 0;
}

template <class T>
void Stack<T> :: push(T iNo)
{
    struct node<T> * newn = NULL;
    newn = new struct node<T>();
    newn->data = iNo;
    newn->next = NULL;

    newn->next = this->first;
    this->first = newn;

    this->iCount++;

}   

template <class T>
T Stack<T> :: pop()
{
    struct node<T> * temp = NULL;
    temp = this->first;
    T iValue = 0;

    if(this->first == NULL)
    {
        cout<<"Stack is empty\n";
        return -1;
    }
    else
    {
        iValue = this->first->data;
        temp = this->first;
        this->first = this->first->next;
        delete temp;

        this->iCount--;

        return iValue;
    }
    
}   

template <class T>
T Stack<T> :: peep()
{
    T iValue = 0;

    if(this->first == NULL)
    {
        cout<<"Stack is empty\n";
        return -1;
    }
    else
    {
        iValue = this->first->data;
        
        return iValue;
    }
}   

template <class T>
void Stack<T> :: Display()
{
    struct node<T> * temp = NULL;
    temp = this->first;

    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" |\n";
        temp = temp->next;
    }
}

template <class T>
int Stack<T> :: Count()
{
    return this->iCount;
}

int main()
{
    Stack <double> sobj;
    double iRet = 0;

    sobj.push(11.9);
    sobj.push(21.8);
    sobj.push(51.09);
    sobj.push(101.87);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    iRet = sobj.pop();
    cout<<"Popped element is : "<<iRet<<endl;
    
    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    iRet = sobj.peep();
    cout<<"Peeped element is : "<<iRet<<endl;
    
    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    return 0;
}