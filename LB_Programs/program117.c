#include<stdio.h>

void Display(int Arr[], int iSize)
{
    int iCnt = 0;

    printf("Numers are : \n");

    for(iCnt = 0; iCnt < iSize; iCnt ++)
    {
        printf("%d \n",Arr[iCnt]);
    }

}

int main()
{
    int iLength = 4;
    int Brr[iLength];  // for this we have to do member by member intialization

    int iCnt = 0;

    printf("Enter numbers of array : \n ");

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        scanf("%d",&Brr[iCnt]);
    }

    Display(Brr, iLength);

    return 0;
}