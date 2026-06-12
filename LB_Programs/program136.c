/*
Take N numbers and return minimum element from array

time complexity : O(N)

*/

#include<stdio.h>
#include<stdlib.h>

int Minimum(int Arr[], int iSize)
{
    int iCnt = 0;
    int iMin = 0;

    iMin = Arr[0];

    for(iCnt = 0; iCnt <iSize; iCnt ++)
    {
        if(Arr[iCnt] < iMin)
        { 
            iMin = Arr[iCnt];
        }
    }

    return iMin;
}
int main()
{
    int iLength = 0, iCnt =0;
    int iRet = 0;
    int * Brr = NULL;

    printf("Enter number of elements : ");
    scanf("%d",&iLength);

    Brr = (int *)malloc(iLength * sizeof(int));

    printf("Enter elements : \n");

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    iRet = Minimum(Brr, iLength);

    printf("Minimum element is : %d",iRet);

    free(Brr);

    return 0;
}