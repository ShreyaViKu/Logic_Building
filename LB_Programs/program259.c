
#include<stdio.h>

void Update(char *str)
{

    while(*str != '\0')
    {
        if(*str =='l')
        {
            *str = 'L';
        }
        str++;
    }

}
int main()
{
    char Arr[50] = {'\0'};  
    int iRet = 0;    

    printf("enter string :\n");
    scanf("%[^'\n']s",Arr);       
    
    Update(Arr);

    printf("Updated string is : %s\n",Arr);


    return 0;
}