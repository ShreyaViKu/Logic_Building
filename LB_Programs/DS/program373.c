/*
beautified Display function with a || around 
*/
#include<stdio.h>
#include<stdlib.h>

struct node 
{
    int data;
    struct node * next;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

void Display(PNODE first)   
{
    while(first != NULL)
    {
        printf("| %d |-> ",first->data);
        first = first->next;
    }
    printf("NULL\n");
}

int Count(PNODE first) 
{
    return 0;
}

void InsertFirst(PPNODE first, int iNo)   
{
    PNODE newn = NULL;        // created pointer which will point to a node
    newn = (PNODE)malloc(sizeof(NODE));  // created node dynamically

    newn->data = iNo;
    newn->next = NULL;

    if(*first == NULL)   // LL is empty
    {
        *first = newn;
    }
    else            // LL contains atleast one node
    {
        newn->next = *first;
        *first = newn;
    }

}

void InsertLast(PPNODE first, int iNo)
{
    PNODE newn = NULL;        
    newn = (PNODE)malloc(sizeof(NODE));  

    newn->data = iNo;
    newn->next = NULL;

    if(*first == NULL)   // LL is empty
    {
        *first = newn;
    }
    else            // LL contains atleast one node
    {

    }
}

void InsertAtPos(PPNODE first, int iNo, int iPos)
{}

void DeleteFirst(PPNODE first)
{}

void DeleteLast(PPNODE first)
{}

void DeleteAtPos(PPNODE first, int iPos)
{}

int main()
{
    PNODE head = NULL;   // created a pointer to point to node

    InsertFirst(&head, 101);
    InsertFirst(&head, 51);
    InsertFirst(&head, 21);
    InsertFirst(&head, 11);

    Display(head);

    return 0;
}