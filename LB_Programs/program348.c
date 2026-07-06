/*
toggle position 3 and 8 bit
with two masks ored with each other 
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iMask1 = 0x00000004;
    UINT iMask2 = 0x00000080;
    UINT iMask = 0x00000000;
    UINT iNo = 0;
    UINT iResult = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iMask = iMask1 | iMask2;

    iResult = iNo ^ iMask;

    printf("Updated number is : %d\n",iResult);
    
    return 0;
}