/*
Queue in CPP
*/
#include<iostream>
using namespace std;

#pragma pack(1)
struct node
{
    int data;
    struct node * next;
};

class Queue
{
    private :
        struct node * first;
        int iCount;
    public:
        Queue();
        void Enqueue(int iNo);      // InsertLast
        int Dequeue();               // DeleteFirst
        void Display();
        int Count();
};

Queue :: Queue ()
{
    this->first = NULL;
    this->iCount = 0;
}

void Queue :: Enqueue(int iNo)
{
    struct node * newn = NULL;
    struct node * temp = NULL;

    newn = new struct node();

    newn->data = iNo;
    newn->next = NULL;

    if(this->first == NULL)
    {
        first = newn;
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
int Queue :: Dequeue()
{
    struct node * temp = NULL;
    temp = this->first;
    int iValue = 0;

    if(this->first == NULL)
    {
        cout<<"Queue is empty\n";
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
           
void Queue :: Display()
{
    struct node * temp = NULL;
    temp = this->first;

    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" |\n";
        temp = temp->next;
    }
}
int Queue :: Count()
{
    return this->iCount;
}

int main()
{
    Queue sobj;
    int iRet = 0;

    sobj.Enqueue(11);
    sobj.Enqueue(21);
    sobj.Enqueue(51);
    sobj.Enqueue(101);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Elements of queue are : "<<iRet<<endl;

    iRet = sobj.Dequeue();
    cout<<"Removed element is : "<<iRet<<endl;
    
    sobj.Display();
    iRet = sobj.Count();
    cout<<"Elements of queue are : "<<iRet<<endl;

    return 0;
}