/*
Stack in CPP Display function
*/
#include<iostream>
using namespace std;

#pragma pack(1)
struct node
{
    int data;
    struct node * next;
};

class Stack
{
    private :
        struct node * first;
        int iCount;
    public:
        Stack();
        void push(int iNo);      // InsertFirst
        int pop();               // DeleteFirst
        int peep();              // DeleteFirst sarkh
        void Display();
        int Count();
};

Stack :: Stack ()
{
    this->first = NULL;
    this->iCount = 0;
}

void Stack :: push(int iNo)
{
    struct node * newn = NULL;
    newn = new struct node();
    newn->data = iNo;
    newn->next = NULL;

    newn->next = this->first;
    this->first = newn;

    this->iCount++;

}   
int Stack :: pop()
{
    return 0;
}             
int Stack :: peep()
{
    return 0;
}            
void Stack :: Display()
{
    struct node * temp = NULL;
    temp = this->first;

    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" |\n";
        temp = temp->next;
    }
}
int Stack :: Count()
{
    return this->iCount;
}

int main()
{
    Stack sobj;
    int iRet = 0;

    sobj.push(11);
    sobj.push(21);
    sobj.push(51);
    sobj.push(101);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    return 0;
}