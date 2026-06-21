#include<stdio.h>

void Display(char str[])
{
    printf("input string is : %s\n",str);
}
int main()
{
    char Arr[50] = {'\0'};      

    printf("enter string :\n");
    scanf("%[^'\n']s",Arr);       
    
    Display(Arr);

    return 0;
}