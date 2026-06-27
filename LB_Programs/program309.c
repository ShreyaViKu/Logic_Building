/*
accept number and check whether 3rd bit is on or off but variables are unsigned 
*/
#include<stdio.h>

int main()
{
    unsigned int iNo= 0;
    unsigned int iMask = 4;
    unsigned int iAns = 0;

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