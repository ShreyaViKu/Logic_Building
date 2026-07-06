/*
toggle position takin from user bit with two masks
ored with each other by left shift
*/
#include<stdio.h>

typedef unsigned int UINT;

UINT ToggleBits(UINT iNo, UINT iPos1, UINT iPos2)
{
    UINT iMask1 = 0x1;
    UINT iMask2 = 0x1;
    UINT iMask = 0x0;
    UINT iResult = 0x0;

    iMask1 = iMask1 << (iPos1 - 1);

    iMask2 = iMask2 << (iPos2 - 1);

    iMask = iMask1 | iMask2;

    iResult = iNo ^ iMask;

    return iResult;

}
int main()
{
    UINT iValue = 0;
    UINT iLocation1 = 0, iLocation2 = 0, iRet = 0;

    printf("Enter number : \n");
    scanf("%d",&iValue);

    printf("Enter first bit position : \n");
    scanf("%d",&iLocation1);

    printf("Enter second bit position : \n");
    scanf("%d",&iLocation2);

    iRet = ToggleBits(iValue, iLocation1, iLocation2);

    printf("Updated number is : %d\n",iRet);
    
    return 0;
}