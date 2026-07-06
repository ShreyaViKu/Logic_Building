/*
Accept number and position of bit from user 
if 1 then 0 otherwise as it is at iPos position bit using a function OffBit()
with filter for iPos !> 32
*/
#include<stdio.h>

typedef unsigned int UINT;

UINT OffBit(UINT iNo, UINT iPos)
{
    UINT iMask = 0x1;
    UINT iResult = 0;

    if(iPos < 1 || iPos > 32)
    {
        printf("Invalid bit position\n");
        return iNo;
    }

    iMask = iMask << (iPos - 1);

    iMask = ~iMask;

    iResult = iNo & iMask;

    return iResult;

}

int main()
{
    UINT iValue1 = 0;
    UINT iLocation = 0;
    UINT iRet = 0; 

    printf("Enter number : \n");
    scanf("%d",&iValue1);

    printf("Enter bit position : \n");
    scanf("%d",&iLocation);

    iRet = OffBit(iValue1, iLocation);

    printf("Updated number is : %d",iRet);

    return 0;
}