/*
create typedef differently 
*/
#include<stdio.h>
#include<stdlib.h>

typedef struct node 
{
    int data;
    struct node * next;
}NODE, *PNODE, **PPNODE;

int main()
{
    PNODE head = NULL;  // as list is empty in starting its null

    return 0;
}