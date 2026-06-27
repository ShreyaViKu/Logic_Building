/*
reverse display    TC = O(2N)
o
lo
llo
ello
Hello
*/
#include<stdio.h>

void ReverseDisplay(char *str)
{
    char *start = NULL;

    start = str;

    while(*str != '\0')
    {
        str++;
    }

    str--; 

    while(start <= str)
    {
        printf("%s\n",str);
        str--;
    }
    
}
int main()
{
    char Arr[50] = {'\0'};

    printf("Enter string : \n");
    scanf("%[^'\n']s",Arr);

    ReverseDisplay(Arr);

    return 0;
}