#include<stdio.h>

int main()
{
    char Arr[50] = {'\0'};      // all character initialized to \0 by default

    printf("enter string :\n");
    scanf("%s",Arr);              // issue

    printf("entered string is : %s\n",Arr);

    return 0;
}