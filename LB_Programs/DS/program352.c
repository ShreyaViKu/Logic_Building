/*
structure creation named node for sizeof struct with paragma pack
*/

#include<stdio.h>

#pragma pack(1)
struct node      // structure declaration
{
    int data;
    struct node *next;

};

int main()
{
    struct node obj;       // object creation & memory allocation

    printf("%d\n",sizeof(obj));    // 12 = 4(int) + 8(pointer)

    return 0;
}