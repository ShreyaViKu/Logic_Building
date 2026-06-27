/*
right shift operator for displaying hexa and decimal
in reverse order  iMask = 0x80000000;
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iMask = 0x80000000;
    int iCnt = 0;

    for(iCnt = 1; iCnt <= 33; iCnt++)      // overflow so last number is 0
    {
        printf("%d : %X\n",iCnt,iMask);    

        iMask = iMask >> 1;

    }

    return 0;
}