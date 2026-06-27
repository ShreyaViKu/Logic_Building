/*
accept number and position to check from user
do iMask = 0x1
then iMask << (iPos - 1)
 
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo= 0;
    UINT iMask = 0x1;
    UINT iAns = 0;
    UINT iPos = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    printf("Enter position : \n");
    scanf("%d",&iPos);

    iMask = iMask << (iPos - 1);

    iAns = iNo & iMask;
    
    if(iAns == iMask)
    {
        printf("bit is on\n");
    }
    else
    {
        printf(" bit is off\n");
    }
    
    return 0;
}