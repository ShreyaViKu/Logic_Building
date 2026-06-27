/*
accept number and check whether 17rth bit 
is on or off but variables are unsigned using typedef
 
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo= 0;
    UINT iMask = 0x10000;
    UINT iAns = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iAns = iNo & iMask;
    
    if(iAns == iMask)
    {
        printf("17th bit is on\n");
    }
    else
    {
        printf("17th bit is off\n");
    }
    
    return 0;
}