/*
accept number and check whether 3rd bit is on or off
*/
#include<stdio.h>

int main()
{
    int iNo= 0;
    int iMask = 4;
    int iAns = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    iAns = iNo & iMask;
    
    if(iAns == iMask)
    {
        printf("Third bit is on\n");
    }
    else
    {
        printf("Third bit is off\n");
    }
    
    return 0;
}