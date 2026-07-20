/*
N numbers Addition with while Iteration
*/

#include<stdio.h>

int Display(int arr[], int iSize)
{
    int i = 0;
    int iSum = 0;

    while( i< iSize)
    {
        iSum = iSum + arr[i];
        i++;
    }
    return iSum;
}

int main()
{

    int brr[] = {10,20,30,40,50};
    int iRet = 0;

   iRet = Display(brr,5);

   printf("Addition is %d\n",iRet);

    return 0;
}