/*
sum till 1 to N  while Iteration without i 
*/

#include<stdio.h>

int Summation(int iNo)
{
    int iSum = 0;

    while(iNo != 0)
    {
        iSum = iSum + iNo;
        iNo--;
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