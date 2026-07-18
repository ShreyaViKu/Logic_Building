/*
Stack in CPP blueprint
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
    
}

void Stack :: push(int iNo)
{
    
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
{}
int Stack :: Count()
{
    return this->iCount;
}

int main()
{
    Stack sobj;

    return 0;
}