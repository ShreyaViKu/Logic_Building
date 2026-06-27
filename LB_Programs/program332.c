/*
toggle the 28th bit 
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo = 0;
    UINT iMask = 0x0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iMask = 0x0800000;

    iNo = iNo ^ iMask;

    printf("Toggled number is : %d",iNo);

    return 0;
}