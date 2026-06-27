/*
displaying hexa and decimal of smallest number 
 iMask = 0x00000000;
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    // Smallest value of int 
    UINT iMask = 0x00000000;
    
    printf("%d\t%X\n",iMask, iMask);

    return 0;
}