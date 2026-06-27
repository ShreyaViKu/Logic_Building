/*
accept number and count number of 1 in binary using while loop 
converting to binary not good
*/
#include<stdio.h>

int main()
{
    int iNo= 0, iCount = 0, iDigit = 0;

    printf("Enter number : \n");
    scanf("%d",&iNo);

    while(iNo != 0)
    {
        iDigit = iNo % 2;

        if(iDigit == 1)
        {
            iCount++;
        }

        iNo = iNo / 2;
    }
    
    printf("Count of 1 is : %d\n", iCount);

    return 0;
}