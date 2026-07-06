/*
toggle position 12 and 23 bit  
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iMask = 0x00400800;
    UINT iNo = 0;
    UINT iResult = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iResult = iNo ^ iMask;

    printf("Updated number is : %d\n",iResult);
    
    return 0;
}