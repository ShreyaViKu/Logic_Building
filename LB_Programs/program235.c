#include<stdio.h>
#include<string.h>    // it is included in libc.lib  string.h includes prototypes of all functions

int main()
{
    char str[] = "Jay Ganesh";

    int iRet = 0;

    iRet = strlen(str);     // function

    printf("Length of string is : %d\n",iRet);

    iRet = sizeof(str);   // operator

    printf("Size of string is : %d\n",iRet);

    return 0;
}