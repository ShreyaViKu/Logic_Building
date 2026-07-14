/*
DCL InsertAtPos function
*/
#include<stdio.h>
#include<stdlib.h>

#pragma pack(1)
struct node
{
    int data;
    struct node * next;
    struct node * prev;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;


void Display(PNODE first, PNODE last)
{
    if(first == NULL && last == NULL)
    {
        return;
    }
    else
    {
        printf(" <=> ");
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

    if(*first == NULL && *last == NULL)
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

    if(*first == NULL && *last == NULL)
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
    int iCount = 0, i= 0;
    PNODE newn = NULL;
    PNODE temp = NULL;

    iCount = Count(*first, *last);

    if((iPos < 1) || (iPos > iCount+1))
    {
        printf("Invalid Position");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(first,last, iNo);
    }
    else if(iPos == iCount+1)
    {
        InsertLast(first,last,iNo);
    }
    else
    {
        temp = *first;

        newn= (PNODE)malloc(sizeof(NODE));
        newn->data = iNo;
        newn->next = NULL;
        newn->prev = NULL;

        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        temp->next->prev = newn;
        newn->next = temp->next;
        temp->next = newn;
        newn->prev = temp;

    }
}

void DeleteFirst(PPNODE first, PPNODE last)
{
    if(*first == NULL && *last == NULL)
    {
        return;
    }
    else if(*first == *last)
    {
        free(*first);
        *first = NULL;
        *last = NULL;
    }
    else 
    {
        *first = (*first)->next;
        free((*last)->next);

        (*first)->prev = *last;
        (*last)->next = *first;
    }
    
}

void DeleteLast(PPNODE first, PPNODE last)
{
    if(*first == NULL && *last == NULL)
    {
        return;
    }
    else if(*first == *last)
    {
        free(*first);
        *first = NULL;
        *last = NULL;
    }
    else 
    {
        *last = (*last)->prev;
        free((*last)->next);

        (*last)->next = *first;
        (*first)->prev = *last;
    }
    
}

void DeleteAtPos(PPNODE first, PPNODE last, int iPos)
{
    int iCount = 0, i= 0;
    PNODE temp = NULL;

    iCount = Count(*first, *last);

    if((iPos < 1) || (iPos > iCount))
    {
        printf("Invalid Position");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(first,last);
    }
    else if(iPos == iCount+1)
    {
        DeleteLast(first,last);
    }
    else
    {
        temp = *first;

        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        temp->next = temp->next->next;
        free(temp->next);

        
    }
}

int main()
{
    PNODE head = NULL;
    PNODE tail = NULL;

    int iRet = 0;

    InsertFirst(&head, &tail, 51);
    InsertFirst(&head, &tail, 21);
    InsertFirst(&head, &tail, 11);

    InsertLast(&head, &tail, 101);
    InsertLast(&head, &tail, 111);
    InsertLast(&head, &tail, 121);

    Display(head,tail);
    iRet = Count(head,tail);
    printf("Number of nodes are : %d\n",iRet);

    DeleteFirst(&head,&tail);

    Display(head,tail);
    iRet = Count(head,tail);
    printf("Number of nodes are : %d\n",iRet);

    DeleteLast(&head,&tail);

    Display(head,tail);
    iRet = Count(head,tail);
    printf("Number of nodes are : %d\n",iRet);

    InsertAtPos(&head,&tail,105,4);

    Display(head,tail);
    iRet = Count(head,tail);
    printf("Number of nodes are : %d\n",iRet);

    return 0;
}