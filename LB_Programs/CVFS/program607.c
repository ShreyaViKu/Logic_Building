/*
#define ERR_OPEN -1  
best industri code all rules
*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024  
#define ERR_OPEN -1   

// change in parameter 

int CountCapital(char * FileName)
{
    char Bufffer[BUFFER_SIZE] = {'\0'};
    int iRet = 0, fd = 0;
    int iCount = 0, i = 0;

    fd = open(FileName,O_RDONLY);
    if(fd == -1)
    {
        return ERR_OPEN;
    }

    while((iRet = read(fd,Bufffer,sizeof(Bufffer))) != 0)
    {
        for(i = 0; i < iRet; i++)
        {
            if(Bufffer[i] >= 'A' && Bufffer[i] <= 'Z')
            {
                iCount++;
            }
        }
        memset(Bufffer,'\0',sizeof(Bufffer));
    }
    close(fd);
    return iCount;
}

int main()
{
    char Fname[30] = {'\0'};
    int iRet = 0;

    printf("enter file name : \n");
    scanf("%[^'\n']s",Fname);

    iRet = CountCapital(Fname);
    if(iRet == ERR_OPEN)
    {
        printf("Unable to open file \n");
    }
    else
    {
        printf("Capital letters are : %d\n",iRet);
    }

    return 0;
}