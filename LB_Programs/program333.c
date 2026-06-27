/*
Accept number from user and position of bit
toggle the position bit 
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo = 0;
    UINT iMask = 0x1;
    UINT iPos = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    printf("Enter bit position : \n");
    scanf("%d",&iPos);

    iMask = iMask << (iPos -1 );

    iNo = iNo ^ iMask;

    printf("Toggled updated number is : %d",iNo);

    return 0;
}