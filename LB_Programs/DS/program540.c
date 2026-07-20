/*
N numbers with Recursion
*/

#include<stdio.h>

void Display(int arr[], int iSize)
{
    static int i = 0;

    if( i< iSize)
    {
        printf("%d\n",arr[i]);
        i++;
        Display(arr, iSize);
    }
}

int main()
{

    int brr[] = {10,20,30,40,50};

    Display(brr,5);

    return 0;
}