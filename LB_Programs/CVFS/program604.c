/*
copy content from one file to another
*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024     

void FileCopy(char FileNameSrc[], char FileNameDest[])
{
    char Bufffer[BUFFER_SIZE] = {'\0'};
    int iRet = 0, fdSrc = 0, fdDest = 0;

    fdSrc = open(FileNameSrc,O_RDONLY);
    
    if(fdSrc == -1)
    {
        printf("Unable to open source file\n");
        return;
    }

    fdDest = creat(FileNameDest,0777);

    if(fdDest == -1)
    {
        printf("Unable to open destination file\n");
        return;
    }

    while((iRet = read(fdSrc,Bufffer,sizeof(Bufffer))) != 0)
    {
        write(fdDest,Bufffer,iRet);
        memset(Bufffer,'\0',sizeof(Bufffer));
    }

    close(fdSrc);
    close(fdDest);

}

int main()
{
    char FnameSrc[30] = {'\0'};
    char FnameDest[30] = {'\0'};

    printf("enter source file name : \n");
    scanf("%[^'\n']s",FnameSrc);

    printf("enter Destination file name : \n");
    scanf(" %[^'\n']s",FnameDest);      // space dila 

    FileCopy(FnameSrc,FnameDest);

    return 0;
}