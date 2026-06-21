#include<stdio.h>

int strlenX(char * const str)
{
    int iCount = 0;

    while(*str != '\0')
    {
        iCount++;
        str++;
    }

    return iCount;
}
int main()
{
    char Arr[50] = {'\0'};  
    int iRet = 0;    

    printf("enter string :\n");
    scanf("%[^'\n']s",Arr);       
    
    iRet = strlenX(Arr);

    printf("length of string is : %d\n ",iRet);

    return 0;
}