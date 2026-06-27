/*
displaying hexa and decimal of largest number
 iMask = 0xFFFFFFFF;
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    // Largest value of int 
    UINT iMask = 0xFFFFFFFF;
    
    printf("%u\t%X\n",iMask, iMask);

    return 0;
}