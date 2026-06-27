/*
accept number and check whether 7rd bit 
is on or off but variables are unsigned using typedef
 
*/
#include<stdio.h>

typedef unsigned int UINT;

int main()
{
    UINT iNo= 0;
    UINT iMask = 64;
    UINT iAns = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iAns = iNo & iMask;
    
    if(iAns == iMask)
    {
        printf("Seventh bit is on\n");
    }
    else
    {
        printf("Seventh bit is off\n");
    }
    
    return 0;
}