/*
Doubly circular in c
*/
#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node * next;
    struct node * prev;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

void DisplayReverse(PNODE first, PNODE last)
{
    if(first == NULL && last == NULL)
    {
        return;
    }
    else
    {
        do
        {
            printf("| %d | <=> ",last->data);
            last = last->prev;
        } while (last != first->prev);
        printf("\n");
    }
    
}

void Display(PNODE first, PNODE last)
{
    if(first == NULL && last == NULL)
    {
        return;
    }
    else
    {
        do
        {
            printf("| %d | <=> ",first->data);
            first = first->next;
        } while (first != last->next);
        printf("\n");
    }
    
}

int Count(PNODE first, PNODE last)
{
    int iCount = 0;
    if(first == NULL && last == NULL)
    {
        return iCount;
    }
    else
    {
        do
        {
            iCount++;
            first = first->next;
        } while (first != last->next);
        return iCount;
    }
}

void InsertFirst(PPNODE first, PPNODE last, int iNo)
{
    PNODE newn = NULL;
    newn = (PNODE)malloc(sizeof(NODE));
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if((*first == NULL)&&(*last == NULL))
    {
        *first = newn;
        *last = newn;
    }
    else
    {
        newn->next = *first;
        (*first)->prev = newn;
        *first = newn;

    }
    (*last)->next = *first;
    (*first)->prev = *last;
}

void InsertLast(PPNODE first, PPNODE last, int iNo)
{
    PNODE newn = NULL;
    newn = (PNODE)malloc(sizeof(NODE));
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if((*first == NULL)&&(*last == NULL))
    {
        *first = newn;
        *last = newn;
    }
    else
    {
        newn->prev = *last;
        (*last)->next = newn;
        *last = newn;


    }
    (*last)->next = *first;
    (*first)->prev = *last;
}

void InsertAtPos(PPNODE first, PPNODE last, int iNo, int iPos)
{
   
}

int main()
{
    PNODE head = NULL;
    PNODE tail = NULL;

    int iRet = 0;

    InsertFirst(&head,&tail, 51);
    InsertFirst(&head,&tail, 21);
    InsertFirst(&head,&tail, 11);
    InsertLast(&head,&tail,101);

    Display(head,tail);
    DisplayReverse(head,tail);

    iRet = Count(head,tail);
    printf("Number of elements are : %d",iRet);

    return 0;
}