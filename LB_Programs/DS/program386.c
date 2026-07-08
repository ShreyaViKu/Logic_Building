/*
8 function template for DLL
*/

#include<stdio.h>
#include<stdlib.h>

#pragma pack(1)     // so memory will be 20 no padding
struct node
{
    int data;
    struct node *next;
    struct node *prev;   // $
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

void Display(PNODE first)
{}

int Count(PNODE first)
{
    return 0;
}

void InsertFirst(PPNODE first, int iNO)
{}

void InsertLast(PPNODE first, int iNO)
{}

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
    PNODE head = NULL;


    return 0;
}