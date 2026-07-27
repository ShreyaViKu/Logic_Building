/*
Customized Virtual File System 
opening and reading same file

*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024     // Macro

int main()
{
    char Bufffer[BUFFER_SIZE] = {'\0'};

    int iRet = 0, fd = 0;

    fd = open("program594.c",O_RDONLY);
    if(fd == -1)
    {
        printf("Unable to open file\n");
        return -1;
    }

    while((iRet = read(fd,Bufffer,sizeof(Bufffer))) != 0)
    {
        write(1,Bufffer,iRet);
        memset(Bufffer,'\0',sizeof(Bufffer));
    }

    close(fd);

    return 0;
}