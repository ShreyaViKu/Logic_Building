/*
Capital letter count of file content
*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024     

// change in parameter 

int CountCapital(char * FileName)
{
    char Bufffer[BUFFER_SIZE] = {'\0'};
    int iRet = 0, fd = 0;
    int iCount = 0, i = 0;

    fd = open(FileName,O_RDONLY);
    if(fd == -1)
    {
        printf("Unable to open file\n");
        return -1;
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
    return iCount;

    close(fd);
}

int main()
{
    char Fname[30] = {'\0'};
    int iRet = 0;

    printf("enter file name : \n");
    scanf("%[^'\n']s",Fname);

    iRet = CountCapital(Fname);
    printf("Capital letters are : %d\n",iRet);

    return 0;
}