#include<stdio.h>
#include<stdlib.h>

int Summation(int Arr[], int iLength)
{
    int iSum = 0, iCnt = 0;

    for(iCnt = 0; iCnt <iLength; iCnt ++)
    {
        iSum += Arr[iCnt];
    }

    return iSum;
}
int main()
{
    int iSize = 0, iRet = 0, iCnt =0;
    int * Brr = NULL;

    printf("Enter number of elements : ");
    scanf("%d",&iSize);

    Brr = (int *)malloc(iSize * sizeof(int));

    printf("Enter elements : \n");

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    iRet = Summation(Brr, iSize);

    printf("Summation is : %d ",iRet);

    free(Brr);

    return 0;
}