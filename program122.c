#include<stdio.h>
#include<stdlib.h>

int Summation(int Arr[] , int iSize)
{

    int iCnt = 0;
    int iSum = 0;

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        iSum += Arr[iCnt];
    }
    return iSum;
}
int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0, iRet = 0;
    
    // Step 1 : Accept no. of elements
    printf("Enter number of elements : \n");
    scanf("%d",&iLength);

    //Step 2 : Allocate the memory
    Brr = (int *)malloc(iLength * sizeof(int));

    printf("Enter the elements :");

    // Step 3 : Accept values from user
    for(iCnt = 0; iCnt < iLength; iCnt ++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    //Step 4 : Use the memory (Logic)
    iRet=Summation(Brr, iLength);

    printf("Summation of array elements is : %d",iRet);

    //Step 5 : Deallocate memory 
    free(Brr);

    return 0;
}