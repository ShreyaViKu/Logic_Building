/*
sum till 1 to N  while Iteration
*/

#include<stdio.h>

int Summation(int iNo)
{
    int i = 0;
    int iSum = 0;

    i = 1;
    while(i<=iNo)
    {
        iSum = iSum + i;
        i++;
    }

    return iSum;
}
int main()
{
    int iValue = 0;
    int iRet = 0;

    printf("Enter Number : \n");
    scanf("%d",&iValue);

    iRet = Summation(iValue);

    printf("Summation is : %d\n",iRet);

    return 0;
}