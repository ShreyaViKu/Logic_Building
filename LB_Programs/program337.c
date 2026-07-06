/*
Accept number from user and 
off the bit at 4 th position if its on
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo = 0;
    UINT iMask = 0xFFFFFFF7;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iNo = iNo & iMask;

    printf("Updated number is : %d",iNo);

    return 0;
}