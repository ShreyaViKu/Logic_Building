/*
N numbers with while Iteration
*/

#include<stdio.h>

void Display(int arr[], int iSize)
{
    int i = 0;

    while( i< iSize)
    {
        printf("%d\n",arr[i]);
        i++;
    }
}

int main()
{

    int brr[] = {10,20,30,40,50};

    Display(brr,5);

    return 0;
}