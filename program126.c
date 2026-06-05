/*
Take N numbers from user and return frequency of Odd numbers
*/

#include<stdio.h>
#include<stdlib.h>

int CountOdd(int Arr[], int iSize)
{
    int iCount = 0, iCnt = 0;

    for(iCnt = 0; iCnt <iSize; iCnt ++)
    {
        if(Arr[iCnt] % 2 != 0)
        {
            iCount++;
        }
    }

    return iCount;
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

    iRet = CountOdd(Brr, iLength);

    printf("frequency of Odd elements is : %d ",iRet);

    free(Brr);

    return 0;
}