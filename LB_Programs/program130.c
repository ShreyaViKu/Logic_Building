/*
Take N numbers and one num1 from user and return if num1 is present or not
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

bool LinearSearch(int Arr[], int iSize, int iNo)
{
    int iCnt = 0;
    bool bFlag = false;

    for(iCnt = 0; iCnt <iSize; iCnt ++)
    {
        if(Arr[iCnt] == iNo)
        {
            bFlag = true;
            break; 
        }
    }

    return bFlag;
}
int main()
{
    int iLength = 0, iCnt =0, iValue = 0;
    bool bRet = false;
    int * Brr = NULL;

    printf("Enter number of elements : ");
    scanf("%d",&iLength);

    Brr = (int *)malloc(iLength * sizeof(int));

    printf("Enter elements : \n");

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    printf("enter element that you want to search : ");
    scanf("%d",&iValue);

    bRet = LinearSearch(Brr, iLength, iValue);

    if(bRet == true)
    {
        printf("element is present ");
    }
    else
    {
        printf("there is no such element");
    }

    free(Brr);

    return 0;
}