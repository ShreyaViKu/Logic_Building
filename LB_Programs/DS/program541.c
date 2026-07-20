/*
N numbers with head Recursion 
Invalid data as i become 5
*/

#include<stdio.h>

void Display(int arr[], int iSize)
{
    static int i = 0;

    if( i< iSize)
    {
        i++;
        Display(arr, iSize);
        printf("%d\n",arr[i]);    // Invalid data as i become 5 
    }
}

int main()
{

    int brr[] = {10,20,30,40,50};

    Display(brr,5);

    return 0;
}