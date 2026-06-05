/*
Take N numbers from user and return if 11 present or not with flag 

exit(0) ---> purn application chya baher janar
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

bool LinearSearch(int Arr[], int iSize)
{
    int iCnt = 0;
    bool bFlag = false;

    for(iCnt = 0; iCnt <iSize; iCnt ++)
    {
        if(Arr[iCnt] == 11)
        {
            bFlag = true;
            break; 
        }
    }

    return bFlag;
}
int main()
{
    int iLength = 0, iCnt =0;
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

    bRet = LinearSearch(Brr, iLength);

    if(bRet == true)
    {
        printf(" element is present ");
    }
    else
    {
        printf("there is no such element");
    }

    free(Brr);

    return 0;
}