/*
Take N numbers from user and return Summation of even numbers
*/

#include<stdio.h>
#include<stdlib.h>

int SumEven(int Arr[], int iSize)
{
    int iSum = 0, iCnt = 0;

    for(iCnt = 0; iCnt <iSize; iCnt ++)
    {
        if(Arr[iCnt] % 2 == 0)
        {
            iSum += Arr[iCnt];
        }
    }

    return iSum;
}
int main()
{
    int iLength = 0, iRet = 0, iCnt =0;
    int * Brr = NULL;

    printf("Enter number of elements : ");
    scanf("%d",&iLength);

    Brr = (int *)malloc(iLength * sizeof(int));

    printf("Enter elements : \n");

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    iRet = SumEven(Brr, iLength);

    printf("Summation of even elements is : %d ",iRet);

    free(Brr);

    return 0;
}