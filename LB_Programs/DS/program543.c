/*
N numbers Addition with Recursion
*/

#include<stdio.h>

int Display(int arr[], int iSize)
{
    static int i = 0;
    static int iSum = 0;

    if( i< iSize)
    {
        iSum = iSum + arr[i];
        i++;
        Display(arr,iSize);
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