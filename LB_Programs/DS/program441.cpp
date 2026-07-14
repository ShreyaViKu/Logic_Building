/*
Doubly circular in cpp
constructor only 
*/
#include<iostream>
using namespace std;

#pragma pack(1)
struct node 
{
    int data;
    struct node *next;
    struct node * prev;
};

typedef struct node NODE;
typedef struct node * PNODE;

#pragma pack(1)
class DoublyCL
{
    private :
        PNODE first;
        PNODE last;
        int iCount;

    public :
        DoublyCL()
        {}
        void Display();
        int Count();
        void InsertFirst(int iNo);
        void InsertLast(int iNo);
        void InsertAtPos(int iNo, int iPos);
        void DeleteFirst();
        void DeleteLast();
        void DeleteAtPos(int iPos);
};

int main()
{
    DoublyCL dobj;

    cout<<sizeof(dobj);
    return 0;
}