/*
Factorial with while iteration
long unsigned int iMult
*/

#include<stdio.h>

unsigned long int Factorial(int iNo)
{
    unsigned long int iMult = 1;

    while(iNo != 0)
    {
        iMult = iMult * iNo;
        iNo--;
    }

    return iMult;
}
int main()
{
    int iValue = 0;
    unsigned long int iRet = 0;

    printf("Enter Number : \n");
    scanf("%d",&iValue);

    iRet = Factorial(iValue);

    printf("Factorial is : %lu\n",iRet);

    return 0;
}