#include<stdio.h>

void strlenX(char str[])
{
    *str = 'A';
}
int main()
{
    char Arr[50] = {'\0'};   

    printf("enter string :\n");
    scanf("%[^'\n']s",Arr);       
    
    strlenX(Arr);

    printf("String is : %s\n",Arr);

    return 0;
}