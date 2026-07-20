/*
N numbers with For recursion
*/

#include<stdio.h>

void Display(int arr[], int iSize)
{
    int i = 0;

    for(i = 0; i< iSize; i++)
    {
        printf("%d\n",arr[i]);
    }
}

int main()
{

    int brr[] = {10,20,30,40,50};

    Display(brr,5);

    return 0;
}