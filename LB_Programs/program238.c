#include<stdio.h>

int main()
{
    char *str = "Ganesh";     

    int iCount = 0;

    while(*str != '\0')
    {
        iCount++;          // strlen(str)
        str++;
    }

    printf("Length of string is : %d\n",iCount);

    return 0;
}