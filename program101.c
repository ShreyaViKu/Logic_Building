#include<stdio.h>

int main()
{
    int Arr[5]= {0};   // all elements 0
    int iCnt = 0;

    printf("Enter the elements : \n");
    
    for(iCnt = 0; iCnt <5; iCnt++)
    {
        scanf("%d",&Arr[iCnt]);
    }

    printf("Elements of array are :\n");

    for(iCnt = 0; iCnt <5; iCnt++)
    {
        printf("%d\n",Arr[iCnt]);
    }

    return 0;
}

// TC : O(1)   static memory allocation of array 