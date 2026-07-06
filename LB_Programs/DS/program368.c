/*
create typedef PPNODE as pointer which holds address of head 
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

int main()
{
    PNODE head = NULL;  // as list is empty in starting its null

    return 0;
}