/*
Accept number from user and position of bit
toggle the position bit using a function ToggleBit()
with filter for iPos !> 32
*/
#include<stdio.h>

typedef unsigned int UINT;

UINT ToggleBit(UINT iNo, UINT iPos)
{
    UINT iMask = 0x1;
    UINT iResult = 0;

    if(iPos < 1 || iPos > 32)
    {
        printf("Invalid bit position\n");
        return iNo;
    }

    iMask = iMask << (iPos -1 );

    iResult = iNo ^ iMask;

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

    iRet = ToggleBit(iValue1, iLocation);

    printf("Toggled updated number is : %d",iRet);

    return 0;
}