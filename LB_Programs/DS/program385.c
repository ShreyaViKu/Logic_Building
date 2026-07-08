/*
Structure creation for Doubly LinkedList
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

int main()
{
    printf("%d\n",sizeof(NODE));     // 20

    return 0;
}