#include<stdio.h>
#include<stdlib.h>

void Display(int Arr[] , int iSize)
{

    int iCnt = 0;

    printf("Elements of array are : \n");
    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        printf("%d\n",Arr[iCnt]);
    }
}
int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0;
    
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
    Display(Brr, iLength);

    //Step 5 : Deallocate memory 
    free(Brr);

    return 0;
}