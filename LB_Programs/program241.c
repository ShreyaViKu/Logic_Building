#include<stdio.h>

int main()
{
    char Arr[50] = {'\0'};      

    printf("enter string :\n");     // special scanf
    scanf("%[^'\n']s",Arr);          // ^ negate symbol it is regular expression regX        

    printf("entered string is : %s\n",Arr);

    return 0;
}