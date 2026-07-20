/*
digit display of number recursion
*/

#include<stdio.h>

void Display(int iNo)
{
    int iDigit = 0;

    if(iNo != 0)
    {
        iDigit = iNo % 10;

        printf("%d\t",iDigit);

        iNo = iNo /10;

        Display(iNo);
    }
}
int main()
{
    int iValue = 0;

    printf("Enter Number : \n");
    scanf("%d",&iValue);

    Display(iValue);

    return 0;
}