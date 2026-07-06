/*
structure creation named node for sizeof struct
*/

#include<stdio.h>

struct node      // structure declaration
{
    int data;
    struct node *next;

};

int main()
{
    struct node obj;       // object creation & memory allocation

    printf("%d\n",sizeof(obj));    // 16 = 4(int) + 4(padding) + 8(pointer)

    return 0;
}