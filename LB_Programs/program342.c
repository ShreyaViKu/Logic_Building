/*
~ negation operator use 
UINT iMask = 0xFFFFFFBF; before
iMask = 40 after  
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iMask = 0xFFFFFFBF;

    printf("Before : %X\n",iMask);

    iMask = ~iMask;

    printf("After : %X\n",iMask);

    return 0;
}